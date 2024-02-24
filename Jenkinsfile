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

}