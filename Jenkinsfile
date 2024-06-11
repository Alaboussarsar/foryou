pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/Alaboussarsar/foryou.git'
        DOCKER_COMPOSE_FILE = 'docker-compose.yml'
    }

    triggers {
        cron('H 6 * * *') // Runs every day at 6 AM
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: "${env.REPO_URL}"
            }
        }

        stage('Build and Run Tests') {
            steps {
                script {
                    sh 'docker-compose down'
                    sh 'docker-compose up --build --exit-code-from maven-project'
                }
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'ExtentReports/**/*', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
            sh 'docker-compose down'
        }

        success {
            echo 'Tests ran successfully!'
        }

        failure {
            echo 'Tests failed.'
        }
    }
}
