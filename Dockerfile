FROM gradle:8.10.2-jdk21-alpine AS build
# Set the working directory
WORKDIR /app

# Copy the project files
COPY gradlew build.gradle.kts settings.gradle.kts ./

# Copy the rest of the project files
COPY src src

# Build the project
RUN gradle build

# Copy the JAR file to the final image
COPY build/libs/*.war /app.war

RUN ls


# Final image
FROM eclipse-temurin:21-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=build /app.war .
run ls
# Expose the port for your application
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.war"]
