FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD /target/alarcha-1.0-SNAPSHOT.jar alarcha-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/alarcha-1.0-SNAPSHOT.jar"]
EXPOSE 8080
