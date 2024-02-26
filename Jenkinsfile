pipeline {
    agent any

    environment {
        APP_VERSION = "1.0.0"
        // SERVER_CREDENTIALS = credentials('ca1c62d2-653e-4c3d-ae0a-53f5a05b75b7')
    }

    stages {
        stage("Build") {

            steps {
                echo "Building the application..."
            }

        }
        stage("Test") {
            when {
                expression {
                    BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
                }
            }

            steps {
                sh "echo ${BRANCH_NAME}"
                echo "Testing the application..."
            }
        }
        stage("Deploy") {

            steps {
                echo "${APP_VERSION}"
                echo "Deploying the application..."
                // echo "Deploying with ${SERVER_CREDENTIALS}"
                withCredentials([
                    usernamePassword(credentialsID: 'ca1c62d2-653e-4c3d-ae0a-53f5a05b75b7', usernameVariable: USER, passwordVariable: PWD)

                ]) {
                    sh "some script ${USER} and ${PWD}"

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