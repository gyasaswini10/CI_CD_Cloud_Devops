# # ---- Build Stage ----
# FROM node:18 AS build
# WORKDIR /app
# COPY package*.json ./
# RUN npm install
# COPY . .
# RUN npm run build

# # ---- Production Stage ----
# FROM nginx:alpine
# COPY --from=build /app/dist /usr/share/nginx/html
# EXPOSE 80
# CMD ["nginx", "-g", "daemon off;"]

# Stage 1: Build the production assets
FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2: Serve the application with Nginx
FROM nginx:alpine
# Copy the built assets from the 'build' stage
COPY --from=build /app/dist /usr/share/nginx/html
# Expose the port Nginx runs on
EXPOSE 80
# Start Nginx
CMD ["nginx", "-g", "daemon off;"]