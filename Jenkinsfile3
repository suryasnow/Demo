pipeline {
   agent any
   tools {
      maven 'Maven'
    }
   stages {
       stage("Stage1") {
                steps {
                    echo "Building" 
                    sh 'mvn -X clean install -DskipTests'
                    echo "Testing"
                    sh 'mvn test'



                    echo "Creating artifact"
                    sh 'mvn package'
                     sleep 3
                    snDevOpsArtifact(artifactsPayload:"""
                    {"artifacts": 
                         [
                             {
                              "name": "avgbrewingapp-mvp32.jar",
                              "version":"0.${env.BUILD_NUMBER}.0",
                             "semanticVersion": "0.${env.BUILD_NUMBER}.0",
                              "repositoryName": "bm-artifacts-repo",
                              "pipelineName": "Average App Pipeline",
                              "taskExecutionNumber":"${env.BUILD_NUMBER}",
                             "stageName":"Stage1",
                              "branchName": "master"
                             }
                         ]
                         }""")



                    echo "Creating package"
                     snDevOpsPackage(name: "avgbrewingapp-pkg2", artifactsPayload: """
                     {"artifacts": 
                     [
                          {
                           "name": "avgbrewingapp-mvp32.jar",
                          "version":"0.${env.BUILD_NUMBER}.0",
                            "semanticVersion": "0.${env.BUILD_NUMBER}.0",
                            "repositoryName": "bm-artifacts-repo",
                            "pipelineName": "Average App Pipeline",
                            "taskExecutionNumber":"${env.BUILD_NUMBER}",
                            "stageName":"Stage1",
                            "branchName": "master"
                        }
                        ]
                        }""")
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml' 
                }
          }
        }
        stage("Stage2") {
           steps {
               echo "Stage2"
            }
        }
      stage("Stage3") {
           steps {
               echo "Stage3"
               snDevOpsChange()
                  echo ">> Deploy in prod"
              
                 
           }
        }
      stage("Stage4") {
             steps{ 

                echo "Stage4" 
                
                echo "Testing"
                sh 'mvn test'
              }

              post {
                always {
                    junit '**/target/surefire-reports/*.xml' 
                }
          }
         } 
      stage("Stage5") {

          steps {
               echo "Stage5"
               
            }
      }
  }
}
