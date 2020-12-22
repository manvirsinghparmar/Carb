pipeline {
    agent {
    label 'master'}

    stages {
        stage('Build') {
            steps {
                echo 'Cleaning Workspace...'
                echo " Branch Name: ${params.branch}"
                bat "mvn clean -X"
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
                bat "mvn install -X"
            }
        }
    }
}
