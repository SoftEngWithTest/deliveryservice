node {
  stage('SCM Checkout') {
    git 'https://github.com/SoftEngWithTest/deliveryservice.git'
  }
  stage('Compile-Package') {
    sh 'mvn package'
  }
}
