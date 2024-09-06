FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/GS_RecursosHumanos.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "GS_RecursosHumanos.jar"]
