pipeline {
    agent {
    label 'master'}

    stages {
        stage('Build') {
            steps {
                echo 'Cleaning Workspace...'
                bat "mvn help:effective-settings help:effective-pom -U clean -X -DskipTests -Dbranch=master"
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
                bat "mvn help:effective-settings help:effective-pom -U deploy -X -DskipTests -Dbranch=master"
            }
        }
    }
}
