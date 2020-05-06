pipeline {
  agent any 
 
 
 tools {
   gradle 'gradle-1'
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
