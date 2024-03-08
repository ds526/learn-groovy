Map defaults = [
    dice: [
        myworkspace: "${WORKSPACE}",
        myParam1: 'test1',
        myParam2: 'test2',
        myParam3: 'test3',
        myParam4: 'test4',
        myParam5: 'test5',
    ]
];

pipeline {
    //agent { docker { image 'linux' } }
    agent any
    parameters {
        // Define params here
        choice(choices: ['1.0.0', '1.2.0'], description: 'Pick Stuff', name: 'MY_VERSION')
        booleanParam(name: 'executeTests', defaultValue: false, description: '')
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
        // stage('log version info') {
        //     steps {
        //         sh 'mvn --version'
        //         sh 'mvn clean install'
        //     }
        // }
        stage("Build Node") {
            agent {
                docker {
                    image 'node:20.11.1-alpine3.19'
                }
            }
            steps {
                echo "Building the application..."
                echo "Deploying version: ${params.MY_VERSION}"
                sh "node --version"
                script {
                    echo ${defaults.dice.myworkspace}
                }

            }
        }
        stage("Build NGINX") {
            agent {
                docker {
                    image 'nginx'
                }
            }
            steps {
                echo "Building the application..."
                echo "Deploying version: ${params.MY_VERSION}"
                echo "TESTING NGINX STATUS: "
                sh "nginx -version"
                sh "hostname"
            }
        }
        stage("Build a Custom Docker Image") {
            agent {
                dockerfile {
                    filename 'Dockerfile'
                    args '-v my_home:/home/ubuntu'
                }
            }
            steps {
                // sh 'hostname'
                sh "pwd"
                sh "cd /home/ubuntu"
                sh "touch my_test_file.txt"
                echo "Add to test file > my_test_file.txt"
            }
        }
        stage("OWASP Scan") {
            steps {
                dependencyCheck additionalArguments: ''' 
                    -o "./" 
                    -s "./"
                    -f "ALL" 
                    --prettyPrint''', odcInstallation: 'dep-chk'

                dependencyCheckPublisher pattern: 'dependency-check-report.xml'

                publishHTML target [

                ]
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
                echo "RUN HOSTNAME CMD: "
                sh "hostname"
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
                    // sh "curl -v -u ${USER}:${PWD} https://www.google.com"
                    echo "MY USER: ${USER}"

                }
                sh "hostname"
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