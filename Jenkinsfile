node{
     stage('SCM Checkout'){
        git 'https://github.com/manish26k/AppiumFramework/'          
     }
     stage('Complie-Package'){
        def mvnHome = tool name: 'MAVEN_HOME', type: 'maven' 
          bat "${mvnHome}/bin/mvn package"
     }
     stage('Email Notification'){
          mail bcc: '', body: '''This is my first email from Jenkin
          Thanks
          Manish''', cc: '', from: '', replyTo: '', subject: 'Sending dummy email from Jenkin', to: 'mani26kg@gmail.com'
     }
}
