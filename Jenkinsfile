pipeline {
    agent {
    label 'master'}

    stages {
        stage('Build') {
            steps {
                echo 'Cleaning Workspace...'
                bat "mvn clean"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
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
