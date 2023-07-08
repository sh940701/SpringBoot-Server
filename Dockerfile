# Base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/SpringBoot-Server-1.0-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
