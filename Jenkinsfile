//Jenkinsfile-2
pipeline {
    agent none
    stages {
        stage('Front End') {
            agent {
                docker {
                    image 'maven:3.8.1-adoptopenjdk-11'                    
                }
            }
            steps {
                sh "mvn --version"
                sh "hostname"
            }
        }
        stage('Back End') {
            agent {
                dockerfile true
            }
            steps {
                sh "node --version"
                sh "curl --version"
                sh "hostname"
            }
        }
        stage('No docker') {
            agent any
            steps {
                sh "hostname"
                sh "mvn --version"
                sh "node --version"
            }
        }
    }
}

/* Jenkinsfile-1
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
            agent any
            steps {
                sh 'docker images'
                sh 'docker ps'
                sh 'hostname'
            }
        }
    }
}
*/