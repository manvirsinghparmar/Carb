pipeline {
    agent {
    label 'master'}

    stages {
        stage('Build') {
            steps {
                echo 'Cleaning Workspace...'
                echo 'Branch Name: ${params.branch}'
                bat "mvn help:effective-settings help:effective-pom -U clean -X"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                bat "mvn test -X"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                bat "mvn help:effective-settings help:effective-pom install -X"
            }
        }
        post{
            always {
                "Build Completed. Current Build Result= ${currentBuild.currentResult}"

                                                }           
        }

    }
}
