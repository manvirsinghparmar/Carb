pipeline {
    agent {
    label 'master'}

    stages {
        stage('Build') {
            steps {
                echo 'Cleaning Workspace...'
                echo 'Branch Name: ${params.branch}'
                bat "mvn clean -U -X"
            }
        }   
         stage('Verify'){
        steps{
        
        echo 'Verify Work Space'
        bat "mvn verify -Dmaven.test.failure.ignore=true -X"
        
            }
        }          
        stage('Compile') {
            steps {
                echo 'Compile.....'
                bat "mvn compile -U -X"
            }
        }
        stage('Test') {
            steps {
                echo 'Test....'
                bat "mvn test -Dmaven.test.failure.ignore=true"
            }
        }
        stage('Install'){
        
        steps{
            
            echo 'install'
            bat "mvn install -Dmaven.test.failure.ignore=true -X"
        }

            }   
       
    }
}
