def gv

pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    parameters {
        string(name: 'VERSION', defaultValue: '2', description: 'version to deploy on prod')
        string(name: 'BRANCH', defaultValue: '', description: 'branch name')
        //choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: false, description: '')
    }

    stages {

         stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }

         }

        stage("build") {
        when {
            expression {
                params.executeTests
            }
        }

            steps {
                script {
                    gv.buildApp()
                }
//
//                 echo "deploying version ${params.VERSION}"
//                 sh 'mvn clean'
//                 sh 'mvn clean install'
//                 sh 'touch index.html'
//                 sh "git add --all"
//                 sh "git commit -m \"Notes for Release ${params.VERSION}\""
//              //   sh "git push -f origin ${BRANCH_NAME}"
//
//                 withCredentials([usernamePassword(credentialsId: 'e552cda5-dfe1-4cf7-86df-d1dbb97ae8da',
//                 passwordVariable: 'password', usernameVariable: 'usr')]) {
//                     sh '''
//                         echo "Multiline shell steps"
//                         ls -lah
//
//                     '''
//                     echo "username: ${usr} and password: ${password}"
//                }
            }
        }

        stage("test") {
            when {
                expression {
                BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
                }
            }

             steps {
                 echo 'test the application'
            }
        }
    }

}