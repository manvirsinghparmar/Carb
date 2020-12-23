pipeline {
    agent {
    label 'master'}

    stages {
        stage('Clean') {
            steps {
                echo 'Cleaning Workspace...'
                echo 'Branch Name: ${params.branch}'
                bat "mvn Clean -X"
            }
        }   
         stage('Verify'){
        steps{
        
        echo 'Verify Work Space'
        bat 'mvn Verify -X'
        
            }
        }          
        stage('Compile') {
            steps {
                echo 'Compile.....'
                bat "mvn Compile -X"
            }
        }
        stage('Test') {
            steps {
                echo 'Test....'
                bat "mvn Test -X"
            }
        }
        stage('install'){
        
        steps{
            
            echo 'install'
            bat "mvn install -X"
        }

            }   
       
    }
}
