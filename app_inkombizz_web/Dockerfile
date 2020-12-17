# Use an official OpenJDK runtime as a parent image
FROM tomcat:8.0.51-jre8-alpine

LABEL maintainer="imam@inkombizz.co.id"

# Set the working directory to /app
# WORKDIR /usr/local/tomcat/webapps/

# Copy the fat jar into the container at /app
COPY /target/app_inkombizz_web.war /usr/local/tomcat/webapps/

# Make port 8282 available to the world outside this container
EXPOSE 8282

# Run jar file when the container launches
CMD chmod +x /usr/local/tomcat/bin/catalina.sh
CMD ["catalina.sh", "run"]
