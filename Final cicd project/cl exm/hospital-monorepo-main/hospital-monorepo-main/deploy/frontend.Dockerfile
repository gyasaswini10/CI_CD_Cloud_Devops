FROM node:18-alpine AS builder
ARG REPO
WORKDIR /build

# install git
RUN apk add --no-cache git

RUN git clone ${REPO} app
WORKDIR /build/app
RUN npm ci
RUN npm run build

FROM nginx:stable-alpine
COPY --from=builder /build/app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
