pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './gradlew clean assemble'               
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'                
            }
        }
        stage('CodeQuality') {
            steps {
                echo 'Code Quality ...'                
            }			
        }		
    }
}

