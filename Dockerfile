FROM fabric8/java-alpine-openjdk8-jre:1.5.1

USER root

ARG version

ENV JAVA_APP_JAR=jenkins-pipeline-example.jar

ADD target/$JAVA_APP_JAR /deployments