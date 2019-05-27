# Specify a base image
FROM node:alpine

# Change working directory before copying files
WORKDIR /opt/cts

# Copy just the package.json file - if it has changed from the previous version, then we can invalidate the cache
# and pull the npm dependencies again
COPY ./package.json ./

# Install some dependencies
RUN npm install

# Copy everything from our current working directory into our container - package.json
COPY ./ ./

# Documentation that describes the port the container expects to have open for communication
EXPOSE 8080

# Default command
CMD ["npm", "start"]