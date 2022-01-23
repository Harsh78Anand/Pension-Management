FROM openjdk:11.0.11-jdk
EXPOSE 8080
COPY ./target/pension-0.0.1-SNAPSHOT.jar app.jar 
ENTRYPOINT ["java","-jar","/app.jar"]