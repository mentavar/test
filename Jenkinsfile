pipeline {
  agent any

  stages {
      stage('Checkout') {
          steps {
              git 'https://github.com/user/repo.git'
          }
      }
      
      stage('Build') {
          steps {
              script {
                  sh 'npm install -g appium'
              }
          }
      }
      
      stage('Test') {
          steps {
              script {
                  // Here you'd put the command to run your Appium tests. For example:
                  sh 'mvn test --file pom.xml -Dappium.hub=http://127.0.0.1:4723/wd/hub -Dwebdriver.driver=appium -Dappium.platformName=Android -Dappium.deviceName="Pixel_6_API_33_1" -Dcucumber.options="--tags '@ANDROID'"'
              }
          }
      }
      
      stage('Results') {
          steps {
              sh 'mvn serenity:aggregate'
          }
      }
  }
}
