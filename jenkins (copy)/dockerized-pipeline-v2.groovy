pipeline {
    agent { label 'agent_1' }

    stages {
         stage('Docker build'){
            steps{
                sh 'docker build -t hello-flask-160122 /external/<PATH-TO_YOUR_FLASK_DIR>'
            }
        }
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
