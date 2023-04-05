FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} amedea-rest-day.jar
ENTRYPOINT ["java","-jar","/amedea-rest-day.jar"]