pipeline {
  agent any 
 
 
 tools {
   gradle 'Gradle-6.4'
 }
 
 stages {
   stage("run backend") {
    steps {
      echo 'executing gradle'
      withGradle() {
         sh './gradlew -v'
      }
    }
   }
 }
}
