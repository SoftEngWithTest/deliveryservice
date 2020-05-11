pipeline {
    agent any

    tools {
        maven 'maven-3'
    }

    stages {
        stage('compile') {
            steps {
                withMaven(maven : 'maven-3') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('test') {
            steps {
                withMaven(maven : 'maven-3') {
                    sh 'mvn test'
                }
            }
        }
        
        stage('package') {
            steps {
                withMaven(maven : 'maven-3') {
                    sh 'mvn package'
                }
            }
        }
        
        stage('deploy') {
            steps {
                withMaven(maven : 'maven-3') {
                    sh 'mvn deploy'
                }
            }
        }
    }

}
