pipeline {
    agent any
    
    stages {
        
        stage("build") {
            steps {
                echo 'this is build stage'
            }
        }
        stage("test") {
            
            steps {
                echo 'this is test stage'
                snDevOpsChange()
            }
        }
        stage("deploy") {
            steps {
                echo 'this is deploy stage'
            }
        }
        
    }   
}
