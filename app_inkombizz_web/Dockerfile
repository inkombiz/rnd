# Use an official OpenJDK runtime as a parent image
FROM tomcat:8.5.4-jre8

# Set the working directory to /app
WORKDIR /usr/local/tomcat/webapps/

# Copy the fat jar into the container at /app
COPY /target/app_inkombizz_web.war /usr/local/tomcat/webapps/

# Make port 8282 available to the world outside this container
EXPOSE 8282

# Run jar file when the container launches
CMD ["catalina.sh", "run"]
