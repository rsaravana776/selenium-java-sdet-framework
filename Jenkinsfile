
pipeline {
    agent any

    environment {
        MAVEN_HOME = '/Users/saravananrajendran/.jenkins/tools/hudson.tasks.Maven_MavenInstallation/maven'
        PATH = "${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Smoke Tests') {
            steps {
                sh 'mvn -version'
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
