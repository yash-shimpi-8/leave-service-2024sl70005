pipeline {
    agent any
    environment {
        SONAR_TOKEN = credentials('sonar-token')
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/yash8shimpi/leave-service.git'
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube Code Inspection') {
            steps {
                sh """
                    mvn sonar:sonar \
                      -Dsonar.projectKey=leave-service \
                      -Dsonar.host.url=http://localhost:9000 \
                      -Dsonar.login=${SONAR_TOKEN}
                """
            }
        }
    }
}
