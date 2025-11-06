# Hospital Management System - Monorepo

This monorepo assembles the University Hospital Management System backend and frontend into a single repository for easier deployment.

Contents:
- `backend/` - Spring Boot backend (cloned from upstream)
- `frontend/` - React (Vite) frontend (cloned from upstream)
- `deploy/` - deployment templates and Dockerfiles
- `docker-compose.yml` - Compose file to run MySQL, backend, and frontend

How to publish to GitHub:

1. Run the setup script from the parent repo root (where this monorepo folder was created):

```powershell
cd <path-to-hospital-frontend>
.\monorepo\setup_monorepo.ps1
```

2. Create a GitHub repository and push:

```powershell
cd monorepo
# Using GitHub CLI (recommended)
gh repo create <org-or-username>/<repo-name> --public --source=. --remote=origin --push

# Or with git commands
git remote add origin https://github.com/<your-org>/<repo-name>.git
git branch -M main
git push -u origin main
```

3. Configure repository secrets (GHCR credentials, DB credentials if needed) and enable Actions.
