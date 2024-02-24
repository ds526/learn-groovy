pipeline {
    agent any

    environment {
        APP_VERSION = "1.0.0"
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
                echo "Testing the application..."
            }
        }
        stage("Deploy") {

            steps {
                echo "${APP_VERSION}"
                echo "Deploying the application..."
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