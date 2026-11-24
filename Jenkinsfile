pipeline {
    agent any
    environment {
        SONAR_TOKEN = credentials('sonar-token')
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/yash-shimpi-8/leave-service-2024SL70005.git'
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
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t leave-service-2024sl70005:1.0 .'
            }
        }
        stage('Deploy to Staging') {
            steps {
                sh '''
                    docker stop leave-service-staging || true
                    docker rm   leave-service-staging || true
                    docker run -d \
                        --name leave-service-staging \
                        -e APP_ENV=staging \
                        -p 8085:8080 \
                        leave-service-2024sl70005:1.0
                '''
            }
        }
    }
}
