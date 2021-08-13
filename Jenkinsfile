pipeline {
  agent any
  stages {
    stage("build") {
      steps {
        maven install
      }
    }
    stage("test") {
      steps {
        echo "Testing the application."
      }
    }
    stage("deploy") {
      steps {
        echo "Deploying the application."
      }
    }
  }
}
