pipeline {
    agent any 
    options { timestamps () }

    stages {
        stage('Renew Auto Scaling') {
            steps {
                renewAutoScalingGroup("jenkins-test", "us-east-1")          
            }
        }
    }
}