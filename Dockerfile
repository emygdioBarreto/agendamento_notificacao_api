
FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/agendamento-notificacao-api-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]