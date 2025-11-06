# Full-stack Docker Compose deployment

This workspace includes a `docker-compose.yml` and helper Dockerfiles in `deploy/` that build the backend and frontend directly from the GitHub repositories and run them with a MySQL database.

Quick start (local):

1. Copy the environment example:

   cp .env.example .env

2. Edit `.env` if you want different DB credentials or repo URLs.

3. Start the stack:

   docker compose up --build

4. Backend will be available at http://localhost:8081
   Frontend will be available at http://localhost:5173 (proxied to nginx on container port 80)

CI/CD notes

- Use GitHub Actions to build images for each repo on push. Build backend with Maven and push to a registry, likewise build frontend and push static image. Use `docker compose` in production or Kubernetes for scale.
- Example workflow: `build-and-push` that builds both images and pushes to GitHub Container Registry then triggers deployment.

Per-repo CI and configuration

1. Backend
   - Copy `deploy/templates/backend.Dockerfile` into the root of the backend repo as `Dockerfile`.
   - Copy `deploy/templates/application.properties.snippet` into `src/main/resources/application.properties` (or merge values) so the app reads env vars with sensible defaults.
   - Add `deploy/templates/backend-ci.yml` to `.github/workflows/` in the backend repo. Configure repository secrets for registry login if needed.

2. Frontend
   - Copy `deploy/templates/frontend.Dockerfile` into the root of the frontend repo as `Dockerfile`.
   - Add `deploy/.github/workflows/frontend-ci.yml` (or `deploy/templates/frontend-ci.yml`) to the frontend repo's `.github/workflows/`.

3. Once both repos push images to a registry, update `.env` with `BACKEND_IMAGE` and `FRONTEND_IMAGE` pointing to the published images and run `docker compose up` on the deployment host.


Switching between local builds and registry images

The compose setup supports two modes:

- Local build (default): `docker compose up --build` — builds images from the provided Dockerfiles which clone the GitHub repos.
- Registry images: set the following env vars in your `.env` and run `docker compose up` (no build):

   BACKEND_IMAGE=ghcr.io/<your-org>/hospital-backend:latest
   FRONTEND_IMAGE=ghcr.io/<your-org>/hospital-frontend:latest

When `image` is present and `docker compose` detects it, Compose will use the image instead of building. Use this in production when your CI has already built and pushed images.
