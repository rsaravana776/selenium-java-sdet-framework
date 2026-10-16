
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Smoke Tests') {
            steps {
                sh 'mvn clean test -Dcucumber.filter.tags="@smoke"'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'reports/**/*, screenshots/**/*',
                             allowEmptyArchive: true
        }
    }
}
