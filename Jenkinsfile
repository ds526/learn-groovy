pipeline {
    agent { docker { image 'maven:3.3.3' } }
    parameters {
        // Define params here
        choice(choices: ['1.0.0', '1.2.0'], description: 'Pick Stuff', name: 'MY_VERSION')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    // tools {
    //     // have tools available to use when building...such as maven mvn etc
    //     maven 'Maven'
    // }

    environment {
        APP_VERSION = "1.0.0"
        // SERVER_CREDENTIALS = credentials('ca1c62d2-653e-4c3d-ae0a-53f5a05b75b7')
    }

    stages {
        stage('log version info') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean install'
            }
        }
        stage("Build") {

            steps {
                echo "Building the application..."
                echo "Deploying version: ${params.MY_VERSION}"
                // sh "mvn --version"
            }

        }
        stage("Test") {
            when {
                expression {
                    // BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
                    params.executeTests
                }
            }

            steps {
                sh "echo ${BRANCH_NAME}"
                echo "Testing the application..."
            }
        }
        stage("Deploy") {

            steps {
                // echo "${APP_VERSION}"
                echo "Deploying the application..."
                // echo "Deploying with ${SERVER_CREDENTIALS}"
                withCredentials([
                    usernamePassword(credentialsId: 'ca1c62d2-653e-4c3d-ae0a-53f5a05b75b7', usernameVariable: USER, passwordVariable: PWD)

                ]) {
                    sh "curl -v -u ${USER}:${PWD} https://www.google.com"

                }
            }
        }
    }
    post {
        always {
            echo "Always run post install..."
        }
        success {
            echo "Always run post success of install..."
        }
        failure {
            echo "Always run post install failure..."
        }

    }

}