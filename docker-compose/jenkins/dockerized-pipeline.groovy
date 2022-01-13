pipeline {
    agent { label 'agent_1' }

    stages {
        stage('Running Flask-API container') {
            steps {
                sh 'docker rm -f flask-api'
                sh 'docker run -d --network jenkins_bridge -h my-flask-app --name flask-api moditamam/hello-flask'
            }
        }

        stage('API call') {
            steps {
                sh 'curl my-flask-app:80'
            }
        }
    }
}