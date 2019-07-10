FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD /target/alarcha-1.0-SNAPSHOT.jar alarcha-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/alarcha-1.0-SNAPSHOT.jar"]
