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
                sh './gradlew test jacocoTestReport check'
            }
			post {
                success {
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
				     publishHTML (target: [
					   allowMissing: false,
					   alwaysLinkToLastBuild: false,
					   keepAll: true,
					   reportDir: 'build/reports/pmd',
					   reportFiles: 'main.html',
					   reportName: "PMD Main Analysis"
				     ])	
				     publishHTML (target: [
					   allowMissing: false,
					   alwaysLinkToLastBuild: false,
					   keepAll: true,
					   reportDir: 'build/reports/pmd',
					   reportFiles: 'test.html',
					   reportName: "PMD Test Analysis"
				     ])	
				     publishHTML (target: [
					   allowMissing: false,
					   alwaysLinkToLastBuild: false,
					   keepAll: true,
					   reportDir: 'build/reports/findbugs',
					   reportFiles: 'main.html',
					   reportName: "Findbugs Main Analysis"
				     ])		  
				     publishHTML (target: [
					   allowMissing: false,
					   alwaysLinkToLastBuild: false,
					   keepAll: true,
					   reportDir: 'build/reports/findbugs',
					   reportFiles: 'test.html',
					   reportName: "Findbugs Test Analysis"
				     ])		                    
                }
            }			
        }
        stage('CodeQuality') {
            steps {
                sh './gradlew sonarqube'              
            }			
        }
        stage('Package') {
            steps {
                sh './gradlew clean capsule'              
            }	
			post {
                success {
                    archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }
        }		
    }
    post {
        always {
           	   
       }     
    }	
}
