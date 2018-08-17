pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './gradlew clean capsule'
                stash name: 'Build', includes: 'build/libs/*.jar'		    
            }
            post {
                success {
                    archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }			
        }
        stage('Test') {
            steps {
                sh './gradlew test jacocoTestReport'
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
                }
            }			
        }
        stage('CodeQuality') {
            steps {
                sh './gradlew sonarqube check'              
            }	
			post {
                success { 
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
        stage('Deploy') {
            steps {                
                sh './gradlew -b deploy.gradle deploy -Pdev_server=10.28.109.121 -Pjar_path=Build'              
            }	
        }
        stage('Acceptance') {
            steps {
                echo 'Acceptance stage'
            }	
        }		
    }
}
