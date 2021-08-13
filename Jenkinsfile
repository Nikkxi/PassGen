pipeline {
  agent any
  stages {
    stage("build") {
      steps {
        withMaven {
         sh "mvn install" 
        }
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
