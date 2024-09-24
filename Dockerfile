# Build the application using Gradle
FROM gradle:7.5.1-jdk17 AS build

# Set working directory
WORKDIR /app

# Copy Gradle files
COPY build.gradle .
COPY settings.gradle .

# Copy the application source code
COPY src ./src

# Build the Spring Boot executable JAR
RUN gradle clean bootJar -x test

# Stage 2: Run the application with OpenJDK
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/location-0.0.1-SNAPSHOT.jar /app/location.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/location.jar"]
