<#
.SYNOPSIS
  Assemble a monorepo containing backend and frontend by cloning the specified GitHub repos.

.DESCRIPTION
  This script clones the backend and frontend repos into a local `monorepo` folder, copies
  the deployment files from the current repository (docker-compose, deploy templates),
  initializes a git repository and makes an initial commit. It does NOT create the remote GitHub repo.

.PARAMETER BackendRepo
  The HTTPS URL of the backend Git repository (default: https://github.com/suneethabulla/hospital-backend.git)

.PARAMETER FrontendRepo
  The HTTPS URL of the frontend Git repository (default: https://github.com/suneethabulla/hospital-frontend.git)

.EXAMPLE
  .\setup_monorepo.ps1

  Creates ./monorepo, clones the default repos into ./monorepo/backend and ./monorepo/frontend,
  copies deployment files, initializes a git repo and commits.
#>

param(
    [string]$BackendRepo = 'https://github.com/suneethabulla/hospital-backend.git',
    [string]$FrontendRepo = 'https://github.com/suneethabulla/hospital-frontend.git'
)

Set-StrictMode -Version Latest

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Definition
$workspaceRoot = Split-Path -Parent $scriptDir   # expected to be the repo root (hospital-frontend)
$dest = Join-Path $workspaceRoot 'monorepo'

Write-Host "Creating monorepo at: $dest"
New-Item -ItemType Directory -Path $dest -Force | Out-Null

Push-Location $dest
try {
    # Clone repos
    if (-not (Test-Path './backend')) {
        git clone $BackendRepo backend
    } else { Write-Host "backend already exists, skipping clone" }

    if (-not (Test-Path './frontend')) {
        git clone $FrontendRepo frontend
    } else { Write-Host "frontend already exists, skipping clone" }

    # Copy deployment helpers from the current repo (parent)
    $deploySrc = Join-Path $workspaceRoot 'deploy'
    if (Test-Path $deploySrc) {
        Write-Host "Copying deploy folder to monorepo"
        Copy-Item -Path $deploySrc -Destination $dest -Recurse -Force
    }

    $composeSrc = Join-Path $workspaceRoot 'docker-compose.yml'
    if (Test-Path $composeSrc) { Copy-Item -Path $composeSrc -Destination $dest -Force }
    $deployMd = Join-Path $workspaceRoot 'DEPLOYMENT.md'
    if (Test-Path $deployMd) { Copy-Item -Path $deployMd -Destination $dest -Force }

    # Create a top-level .gitignore
    $gitignore = @(
        '# Node & Java build artifacts',
        'node_modules/',
        'frontend/node_modules/',
        'backend/target/',
        '*.log',
        '.env',
        'monorepo/**/node_modules',
        '.idea/',
        '.vscode/'
    ) -join "`n"
    $gitignore | Out-File -Encoding UTF8 -FilePath (Join-Path $dest '.gitignore') -Force

    # Initialize git repository and commit
    if (-not (Test-Path (Join-Path $dest '.git'))) {
        git init
        git add .
        git commit -m "Initial import: backend + frontend + deployment templates"
        Write-Host "Initialized git repo in $dest. Add a remote and push to publish."
    } else { Write-Host "Git repo already initialized in $dest" }

    Write-Host "Monorepo assembled successfully. Next steps:"
    Write-Host "  cd $dest"
    Write-Host "  gh repo create <org>/<repo-name> --public --source=. --remote=origin --push" -ForegroundColor Yellow
    Write-Host "  OR: git remote add origin <git-url>; git branch -M main; git push -u origin main" -ForegroundColor Yellow
}
finally { Pop-Location }
