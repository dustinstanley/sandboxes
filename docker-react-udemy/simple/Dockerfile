# Multi-phase build with two phases - build/nginx

# "Build phase" - Creates a "production" build of the react app.  Phase is named 'builder'
FROM node:alpine as builder
WORKDIR '/app'
COPY package.json .
RUN npm install
COPY . .
RUN npm run build

FROM nginx
EXPOSE 80
COPY --from=builder /app/build /usr/share/nginx/html
