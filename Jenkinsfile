pipeline {
    agent any
    tools {
        maven 'mvn-3.5.2'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn validate'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            junit 'build/reports/**/*.xml'
        }
    }
}