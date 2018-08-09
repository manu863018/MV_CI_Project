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
                sh './gradlew test jacocoTestReport'
            }
        }
        stage('CodeQuality') {
            steps {
                sh './gradlew sonarqube'              
            }			
        }		
    }
    post {
        always {
           junit 'build/test-results/test/*.xml'
           publishHTML (target: [
             allowMissing: false,
             alwaysLinkToLastBuild: false,
             keepAll: true,
             reportDir: 'build/reports/tests/test',
             reportFiles: 'index.html',
             reportName: "Test Summary"
	       ])
           publishHTML (target: [
             allowMissing: false,
             alwaysLinkToLastBuild: false,
             keepAll: true,
             reportDir: 'build/reports/jacoco',
             reportFiles: 'index.html',
             reportName: "Code Coverage"
           ])	       
       }
       success {
           archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
       }      
    }	
}

