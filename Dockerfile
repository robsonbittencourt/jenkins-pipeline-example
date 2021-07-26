FROM fabric8/java-alpine-openjdk11-jre:1.8

USER root

ARG version

ENV JAVA_APP_JAR=jenkins-pipeline-example.jar

ADD target/$JAVA_APP_JAR /deployments