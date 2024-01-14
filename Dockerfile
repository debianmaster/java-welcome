
FROM openjdk:8-jre-slim

WORKDIR /app

COPY build/libs/java-welcome.jar .

CMD ["java", "-jar", "java-welcome.jar"]
