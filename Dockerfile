FROM fabric8/java-alpine-openjdk8-jre:1.5.1

USER root

ARG profile
ARG version

ENV JAVA_APP_JAR=jenkins-pipeline-example-$version.jar \
    SPRING_PROFILES_ACTIVE=$profile

ADD target/$JAVA_APP_JAR /deployments