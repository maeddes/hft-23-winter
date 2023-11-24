# Use a base image with a web server (e.g., Nginx)
FROM nginx:latest

# Set an environment variable with a default API base URL
ENV API_BASE_URL http://localhost:8090

# Copy your web application files to the appropriate directory
COPY . /usr/share/nginx/html

# Create a script to update the API base URL
# RUN echo 'window.API_BASE_URL = "'"$API_BASE_URL"'";' > /usr/share/nginx/html/config.js

# Expose the web server port (default is 80)
EXPOSE 80

# Start the web server
CMD ["nginx", "-g", "daemon off;"]
