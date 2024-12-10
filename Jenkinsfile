// pipeline {
//     agent any 
//     options { timestamps () }

//     stages {
//         stage('Renew Auto Scaling') {
//             steps {
//                 renewAutoScalingGroup("jenkins-test", "us-east-1")          
//             }
//         }
//     }
// }
pipeline {
    agent any 
    options { timestamps() }

    stages {
        stage('Renew Auto Scaling') {
            steps {
                script {
                    // Example AWS CLI command to update Auto Scaling Group capacity
                    sh """
                        aws autoscaling update-auto-scaling-group \
                            --auto-scaling-group-name jenkins-test \
                            --desired-capacity 3 \
                            --region us-east-1
                    """
                }
            }
        }
    }
}
