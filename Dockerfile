FROM gradle:8.10.2-jdk21-alpine AS build
# Set the working directory
WORKDIR /coffee-finder

# Copy the project files
COPY gradlew build.gradle.kts settings.gradle.kts ./

COPY src src

#
# Build the project
RUN gradle build

# Copy the JAR file to the final image
COPY build/libs/*.war /app.war
COPY sql /sql

FROM eclipse-temurin:21-alpine

WORKDIR /coffee-finder

COPY --from=build /app.war .
COPY --from=build /sql /sql


EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.war"]
