# Use an official Java runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /anyapi

# Copy the packaged JAR file into the container
COPY target/anyapi-0.0.1-SNAPSHOT.jar.original anyapi.jar

# Expose the application port (default Spring Boot port)
EXPOSE 1080

# Run the application
ENTRYPOINT ["java", "-jar", "anyapi.jar"]
