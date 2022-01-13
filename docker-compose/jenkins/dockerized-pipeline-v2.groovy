pipeline {
    agent { label 'agent_1' }

    stages {
        stage('API call') {
            agent {
                docker {
                    image 'moditamam/hello-flask'
                    reuseNode true
                }
            }
            steps {
                // sleep 20
                sh 'python /app/flask_app.py &'
                sh 'curl 127.0.0.1:80'
            }
        }
    }
}
