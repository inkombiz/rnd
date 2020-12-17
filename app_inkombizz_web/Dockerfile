# Use an official OpenJDK runtime as a parent image
FROM tomcat:latest

# Set the working directory to /app
WORKDIR /usr/local/tomcat/webapps/

# Copy the fat jar into the container at /app
COPY /target/api_inkombizz_master.jar /usr/local/tomcat/webapps/

# Make port 8282 available to the world outside this container
EXPOSE 8282

# Run jar file when the container launches
CMD ["catalina.sh", "run"]
