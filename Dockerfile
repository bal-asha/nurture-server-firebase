# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle/ ./gradle/

# Copy the source code
COPY src/ ./src/

# Build the application using Gradle
RUN ./gradlew clean build -x test

# Expose the port your Spring Boot application will run on (default is 8080)
EXPOSE 8080

# Define environment variables (if needed)
# ENV SPRING_PROFILES_ACTIVE=production

# Specify any additional runtime arguments for the JAR (optional)
# CMD ["java", "-jar", "build/libs/your-spring-boot-app.jar", "--server.port=8080"]

# Specify the command to run your application (uncomment the line above for this approach)
CMD ["java", "-jar", "build/libs/nurture-server-1.0.jar"]
