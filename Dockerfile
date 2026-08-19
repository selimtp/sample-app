FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Produced by the Build stage (mvn clean install) before docker build runs.
COPY target/*.jar app.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
