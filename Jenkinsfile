pipeline {
    agent {
        docker {
            image 'node:16-alpine'
        }
    }
    stages {
        stage('Check Container') {
            steps {
                sh 'node --version'
                sh 'hostname'
            }
        }
        stage('Back to Agent') {
            agent 'Built-in-node'
            steps {
                sh 'docker images'
                sh 'docker ps'
                sh 'hostname'
            }
        }
    }
}