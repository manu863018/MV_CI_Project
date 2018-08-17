pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './gradlew clean capsule'
                stash includes: 'build/libs/*.jar', name: 'Build'		    
            }
            post {
                success {
                    archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }			
        }
        		
    }
}

