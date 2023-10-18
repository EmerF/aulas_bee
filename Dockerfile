# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim-buster

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/tech-empowers-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (the default port for Spring Boot applications)
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]

