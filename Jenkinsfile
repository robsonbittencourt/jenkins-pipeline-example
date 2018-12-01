node{

  git branch: "test", url: "https://github.com/robsonbittencourt/jenkins-pipeline-example" 

  stage('Test') {
    parallel 'unit': {
        stage('Unit Tests') {
            withEnv(["JAVA_HOME=${ tool "java-8" }", "PATH+MAVEN=${ tool "maven" }/bin:${env.JAVA_HOME}/bin"]) {
                sh "mvn test"
            }
        }
    }, 'integration': {
        stage('Integration Tests') {
            withEnv(["JAVA_HOME=${ tool "java-8" }", "PATH+MAVEN=${ tool "maven" }/bin:${env.JAVA_HOME}/bin"]) {
                sh "mvn verify -Pit-tests"
            }
        }
    }  
  }

  stage ('Sonar') {
    withEnv(["JAVA_HOME=${ tool "java-8" }", "PATH+MAVEN=${ tool "maven" }/bin:${env.JAVA_HOME}/bin"]) {
        sh "mvn sonar:sonar -Dsonar.host.url=http://sonar:9000"
    }
  }
  
  stage ('Ui Tests') {
    withEnv(["JAVA_HOME=${ tool "java-8" }", "PATH+MAVEN=${ tool "maven" }/bin:${env.JAVA_HOME}/bin"]) {
        sh "mvn verify -Pui-tests"
    }
  }

  stage ('Build Jar') {
    withEnv(["JAVA_HOME=${ tool "java-8" }", "PATH+MAVEN=${ tool "maven" }/bin:${env.JAVA_HOME}/bin"]) {
        sh "mvn package -Dmaven.test.skip=true"
    }
  }
  
}