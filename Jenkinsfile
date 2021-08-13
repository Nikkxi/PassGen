pipeline {
  agent any
  stages {
    stage("build") {
      steps {
        mvn install
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
