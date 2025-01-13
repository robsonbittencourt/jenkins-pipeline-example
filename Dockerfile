FROM amazoncorretto:21-alpine

WORKDIR /app

COPY ./build/libs/jenkins-pipeline-example-1.0.0.jar /app/jenkins-pipeline-example-1.0.0.jar

CMD ["java", "-jar", "/app/jenkins-pipeline-example-1.0.0.jar"]
