FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hello-jwt-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/hello-jwt-0.0.1-SNAPSHOT.jar"]