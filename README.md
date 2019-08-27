# Jenkins Pipeline Example

### Goal

The purpose of this project is to demonstrate with a simple project how a software delivery pipeline can be assembled using Jenkins.

Some important steps can be seen in this project, such as unit testing, interface testing, static code analysis, and deploying Docker images.

A pipeline can contain more or less steps depending on your application scenario. The important thing is to understand the flow needed to deliver the application with confidence, and to automate this flow.

Use this project as a base for ideas for your own pipeline.

![stages-ci](media/stages-ci.png)

### How to use

Having Docker installed, execute the commands below:

```
docker pull elgalu/selenium

docker-compose up -d
```

After that some services will be available:

**App Products DSV** - http://localhost:8081

Simple app in DSV stage

**App Products HML** - http://localhost:8085

Simple app in HML stage

**App Products PRD** - http://localhost:8090

Simple app in PRD stage

**Jenkins** - http://localhost:8080

Jenkins to run CI and CD jobs

**Sonarqube** - http://localhost:9000

Sonarqube is a tool that performs static code analysis and points out possible problems. 

**Zalenium** - http://localhost:4444/grid/admin/live?refresh=10

Zalenium is a extension of Selenium Grid to execute Selenium tests in parallel


When accessing Jenkins there are two jobs already configured: 

#### products-ci
- Download the project from Github
- Run unit-tests
- Execute Sonarqube analysis
- Build jar artifact
- Build and deploy Docker image with DSV tag
- Run docker container using DSV tag

#### products-cd
- Download the project from Github
- Build and deploy Docker image with HML tag
- Run docker container using HML tag
- Run interface tests in HML stage
- Build and deploy Docker image with PRD tag
- Run docker container using PRD tag

### Jenkins configurations

- Add your Dockerhub user and pass in credential with ID 'registryCredential' in Jenkins