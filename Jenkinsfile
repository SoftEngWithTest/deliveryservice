pipeline {
    agent any

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
    }

}