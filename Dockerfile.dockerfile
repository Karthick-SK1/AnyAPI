# Use an official Java 17 runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/anyapi-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 1080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
