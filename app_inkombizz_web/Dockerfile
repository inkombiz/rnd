# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jre-alpine

# set shell to bash
RUN apk update && apk add bash

# Set the working directory to /app
WORKDIR /app

# Copy the fat jar into the container at /app
COPY /target/api_inkombizz_master.jar /app

# Make port 8282 available to the world outside this container
EXPOSE 8282

# Run jar file when the container launches
CMD ["java", "-jar", "api_inkombizz_master.jar"]
