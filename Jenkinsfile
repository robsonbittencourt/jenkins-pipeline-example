pipeline {
    agent any
    tools {
        maven 'maven1'
    }
    options {
        buildDiscarder logRotator(daysToKeepStr: '5', numToKeepStr: '7')
    }
    stages{
        stage('Build'){
            steps{
                 sh script: 'mvn clean package'
                 archiveArtifacts artifacts: 'target/*.war', onlyIfSuccessful: true
            }
        }
        stage('Upload War To Nexus'){
            steps{
                script{

                    def mavenPom = readMavenPom file: 'pom.xml'
                    def nexusRepoName = mavenPom.version.endsWith("SNAPSHOT") ? "simpleapp-snapshot" : "simpleapp-release"
                    nexusArtifactUploader artifacts: [
                        [
                            artifactId: 'simple-app', 
                            classifier: '', 
                            file: 'target/simple-app-1.0.0.war', 
                            type: 'war'
                        ]
                    ], 
                  credentialsId: 'Nexus3', 
                  groupId: 'in.javahome', 
                  nexusUrl: '65.0.73.39:8080', 
                  nexusVersion: 'nexus3', 
                  protocol: 'http', 
                  repository: 'testrepo', 
                  version: '1.0.0'
                    }
            }
        }
    }
}
