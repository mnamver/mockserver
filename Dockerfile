FROM openjdk:8
ADD target/mockserver-0.0.1-SNAPSHOT.jar mockserver-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mockserver-0.0.1-SNAPSHOT.jar"]
