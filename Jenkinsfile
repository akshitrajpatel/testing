pipeline {
    agent any
    
    tools {
        maven 'maven'          // Ensure Maven is configured in Jenkins Global Tool Configuration
        jdk 'JDK21'            // Ensure JDK21 is configured in Jenkins Global Tool Configuration
    }

    stages {
        // Verify environment setup
        stage('Verify JAVA_HOME') {
            steps {
                echo 'Verifying Java environment...'
                bat 'echo %JAVA_HOME%'
                bat 'java -version'
            }
        }

        // Checkout source code from repository
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        // Build the project
        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean compile'
            }
        }

        // Run Selenium TestNG tests
        stage('Run Tests') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
            post {
                always {
                    echo 'Archiving test results...'
                    junit '**/target/surefire-reports/*.xml' // Publish JUnit-style XML test results
                }
            }
        }

        // Generate and publish HTML reports
        stage('Publish Report') {
            steps {
                echo 'Generating and publishing reports...'
                // If TestNG HTML reports are generated, archive them for visibility
                publishHTML(target: [
                    allowMissing: true,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'TestNG HTML Report'
                ])
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs() // Cleanup workspace after build
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}
