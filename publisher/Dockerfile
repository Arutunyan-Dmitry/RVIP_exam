FROM openjdk:17-jdk

WORKDIR /app
COPY ./publisher/build/libs/publisher-0.0.1-SNAPSHOT.jar /app/publisher-0.0.1-SNAPSHOT.jar
EXPOSE 8080

CMD ["java", "-jar", "publisher-0.0.1-SNAPSHOT.jar"]