La1 Branching
Practical 1:
------------

Create a GitHub repository named webAppProject. In the main branch, add index.html. Create three branches: adminfeature, userfeature, and managerfeature. In each, add the respective HTML file admin.html, user.html, and manager.html. Merge all branches into main and push the final result to GitHub.

Pre requirement
---------------
1. webAppProject local Directory
2. webAppProject remore repositoty

Steps:
1. create main branch and push index.html
2. create 3 branches named with adminfeature, userfeature and manager feature push respective html files into branches
3. merge adminfeature, userfeature and manager branch with main branch.

Step1:

git init
git add index.html
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/url
git push -u origin main

Step2
git branch adminfeature
git checkout adminfeature
git add admin.html
git commit -m "admin page commited in branch"
git push -u origin adminfeature

git checkout main
git branch userfeature
git checkout userfeature
git add user.html
git commit -m "user page commited in branch"
git push -u origin userfeature

git checkout main
git branch managerfeature
git checkout managerfeature
git add manager.html
git commit -m "manager page commited in branch"
git push -u origin managerfeature

step3:

git checkout main
git merge adminfeature -m "adminfeature merged with main"
git merge userfeature -m "userfeature merged with main"
git merge managerfeature -m "managerfeature merged with main"
git push -u origin main

finally clone project into your local directory

git clone https://github.com/srithar/webAppProject.git



Npm install   =>npm i. vite
















To   remove remote origin  git hub
Git remote remove origin 




Action genral






















SKILL 5- jenkins frontend
WINDOWS BASH COMMAND

server.port=8081




git push -u origin master
TOMCAT->START

C DRIVE-> PROGRAM FILES->
APPACHE TOMCAT 

DOUBLE CLICK IT






Juenkins +new intrm

Free style



Source code managemnet 
Git

Triggers
Poll scm









Build a Jenkins pipeline to pull, build, test, and deploy React app from Git.
-----------------------------------------------------------------------------
WINDOWS BASH COMMAND
Steps:
-----

Extract the source code from https://github.com/srithars/cloud-devops/blob/main/Skill%205.zip

Git steps:
----------
git init    

git add .   

git commit -m "first commit" 

git branch -M main   

git remote add origin https://github.com/srithars/ecommerce-front.git

git push -u origin main

Apache Running in, 
http://localhost:9090/

Jenkins Running in,
http://localhost:8080/


Jenkins Configuration:
1. Source Code Management
https://github.com/srithars/ecommerce-front.git

2. Branches to build
./main

3. Triggers
Poll SCM-> * * * * *

4. Environment
Delete workspace before build starts

5. Build Steps

5.1 Execute Windows batch command
call npm install
call npm run build

5.2 Execute Windows batch command
rmdir /S /Q "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\ecommerce"
/S = Delete all files and subfolders (recursively).
/Q = Quiet mode; no confirmation prompts.

mkdir "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\ecommerce"

xcopy /E /I /Y dist\* "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\ecommerce"
/E = Copy all subdirectories, even empty ones.
/I = Treat destination as a directory (helps when it doesn't exist yet).
/Y = Suppress "overwrite?" confirmation for existing files.


5.3 Execute Windows batch command
net stop Tomcat9
net start Tomcat9


-->Click Build now

Final deployment,
http://localhost:9090/ecommerce/

5.1 Execute Windows batch command
call npm install
call npm run build





FREE STYLE PROJECT
5.2 Execute Windows batch command
rmdir /S /Q "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\ecommerce"
/S = Delete all files and subfolders (recursively).
/Q = Quiet mode; no confirmation prompts.

mkdir "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\ecommerce"

xcopy /E /I /Y dist\* "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\ecommerce"
/E = Copy all subdirectories, even empty ones.
/I = Treat destination as a directory (helps when it doesn't exist yet).
/Y = Suppress "overwrite?" confirmation for existing files.








5.3 Execute Windows batch command
net stop Tomcat9
net start Tomcat9

Skill6 backend ecomentrcwe

                        PIPILEINES PRACTICAL 2   NOT FREE STYLE PROJECT
                        
                        
                        
                        
                        pipeline {
                            agent any //wbere I want to deploy in jenkins from multiple nodes
                        
                            tools {
                                jdk 'JDK_HOME'
                                maven 'MAVEN_HOME'
                            }
                        
                            environment {
                                TOMCAT_URL = 'http://localhost:9090/manager/text' // eherer I want to deploy
                                TOMCAT_USER = 'admin'
                                TOMCAT_PASS = 'admin'
                        
                                BACKEND_REPO = 'https://github.com/gyasaswini10/CICD_Practicle_2_Backend.git
                                FRONTEND_REPO = 'https://github.com/gyasaswini10/CI_CD_Practicle_2_frontend.git' 
                        
                                BACKEND_DIR = 'backend'
                                FRONTEND_DIR = 'frontend'
                        
                                BACKEND_WAR = 'backend/target/springapp1.war'
                                FRONTEND_WAR = 'frontend/frontapp1.war'
                            }
                        
                            stages {
                                stage('Clone Repositories') {
                                    steps {
                                        dir("${env.BACKEND_DIR}") {
                                            git branch: 'main', url: "${env.BACKEND_REPO}"
                                        }
                                        dir("${env.FRONTEND_DIR}") {
                                            git branch: 'main', url: "${env.FRONTEND_REPO}"
                                        }
                                    }
                                }
                        
                                stage('Build React Frontend') {
                                    steps {
                                        script {
                                            def nodeHome = tool name: 'NODE_HOME', type: 'jenkins.plugins.nodejs.tools.NodeJSInstallation'
                                            env.PATH = "${nodeHome}\\bin;${env.PATH}"
                                        }
                                        dir("${env.FRONTEND_DIR}") {
                                            bat 'npm install'
                                            bat 'npm run build'
                                        }
                                    }
                                }
                        
                                stage('Package React as WAR') {
                                    steps {
                                        script {
                                            def warDir = "${env.FRONTEND_DIR}\\war_content"
                                            bat "if exist ${warDir} rmdir /S /Q ${warDir}"
                                            bat "mkdir ${warDir}\\META-INF"
                                            bat "mkdir ${warDir}\\WEB-INF"
                                            bat "xcopy /E /Y /I \"${env.FRONTEND_DIR}\\dist\\*\" \"${warDir}\\\""
                                            bat "jar -cvf ${env.FRONTEND_WAR} -C ${warDir} ."
                                        }
                                    }
                                }
                        
                                stage('Build Spring Boot App') {
                                    steps {
                                        dir("${env.BACKEND_DIR}") {
                                            bat 'mvn clean package'
                                            bat 'rename target\\*.war springapp1.war'
                                        }
                                    }
                                }
                        
                                stage('Deploy Spring Boot WAR') {
                                    steps {
                                        bat "curl -u ${env.TOMCAT_USER}:${env.TOMCAT_PASS} --upload-file \"${env.BACKEND_WAR}\" \"${env.TOMCAT_URL}/deploy?path=/springapp1&update=true\""
                                    }
                                }
                        
                                stage('Deploy Frontend WAR') {
                                    steps {
                                        bat "curl -u ${env.TOMCAT_USER}:${env.TOMCAT_PASS} --upload-file \"${env.FRONTEND_WAR}\" \"${env.TOMCAT_URL}/deploy?path=/frontapp1&update=true\""
                                    }
                                }
                            }
                        }

pipeline {
    agent any // Deploy from multiple nodes

    tools {
        jdk 'JDK_HOME'
        maven 'MAVEN_HOME'
    }

    environment {
        TOMCAT_URL = 'http://localhost:9090/manager/text'
        TOMCAT_USER = 'admin'
        TOMCAT_PASS = 'admin'

        BACKEND_REPO = 'https://github.com/gyasaswini10/CICD_Practicle_2_Backend.git'
        BACKEND_DIR = 'backend'
        BACKEND_WAR = 'backend/target/springapp1.war'
    }

    stages {
        stage('Clone Backend Repository') {
            steps {
                dir("${env.BACKEND_DIR}") {
                    git branch: 'main', url: "${env.BACKEND_REPO}"
                }
            }
        }

        stage('Build Spring Boot App') {
            steps {
                dir("${env.BACKEND_DIR}") {
                    bat 'mvn clean package'
                    bat 'rename target\\*.war springapp1.war'
                }
            }
        }

        stage('Deploy Spring Boot WAR') {
            steps {
                bat "curl -u ${env.TOMCAT_USER}:${env.TOMCAT_PASS} --upload-file \"${env.BACKEND_WAR}\" \"${env.TOMCAT_URL}/deploy?path=/springapp1&update=true\""
            }
        }
    }
}

pipeline {
    agent any // Deploy from multiple nodes

    tools {
        // Make sure NODE_HOME is configured in Jenkins global tools
    }

    environment {
        TOMCAT_URL = 'http://localhost:9090/manager/text'
        TOMCAT_USER = 'admin'
        TOMCAT_PASS = 'admin'

        FRONTEND_REPO = 'https://github.com/gyasaswini10/CI_CD_Practicle_2_frontend.git'
        FRONTEND_DIR = 'frontend'
        FRONTEND_WAR = 'frontend/frontapp1.war'
    }

    stages {
        stage('Clone Frontend Repository') {
            steps {
                dir("${env.FRONTEND_DIR}") {
                    git branch: 'main', url: "${env.FRONTEND_REPO}"
                }
            }
        }

        stage('Build React Frontend') {
            steps {
                script {
                    def nodeHome = tool name: 'NODE_HOME', type: 'jenkins.plugins.nodejs.tools.NodeJSInstallation'
                    env.PATH = "${nodeHome}\\bin;${env.PATH}"
                }
                dir("${env.FRONTEND_DIR}") {
                    bat 'npm install'
                    bat 'npm run build'
                }
            }
        }

        stage('Package React as WAR') {
            steps {
                script {
                    def warDir = "${env.FRONTEND_DIR}\\war_content"
                    bat "if exist ${warDir} rmdir /S /Q ${warDir}"
                    bat "mkdir ${warDir}\\META-INF"
                    bat "mkdir ${warDir}\\WEB-INF"
                    bat "xcopy /E /Y /I \"${env.FRONTEND_DIR}\\dist\\*\" \"${warDir}\\\""
                    bat "jar -cvf ${env.FRONTEND_WAR} -C ${warDir} ."
                }
            }
        }

        stage('Deploy Frontend WAR') {
            steps {
                bat "curl -u ${env.TOMCAT_USER}:${env.TOMCAT_PASS} --upload-file \"${env.FRONTEND_WAR}\" \"${env.TOMCAT_URL}/deploy?path=/frontapp1&update=true\""
            }
        }
    }
}
