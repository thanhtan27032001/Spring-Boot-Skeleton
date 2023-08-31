FROM openjdk:17-jdk-alpine
MAINTAINER GaDen
COPY target/skeleton-0.0.1-SNAPSHOT.jar skeleton-0.0.1-snapshot.jar
ENTRYPOINT ["java","-jar","/skeleton-0.0.1-snapshot.jar"]