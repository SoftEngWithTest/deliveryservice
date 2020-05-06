node {
 stage 'checkout'
 checkout scm

stage 'build'
 timeout(time: 15, unit: 'MINUTES') {
 sh "./gradlew clean build"
 }

stage 'test'
 timeout(time: 15, unit: 'MINUTES') {
 sh "./gradlew test"
 }
}
