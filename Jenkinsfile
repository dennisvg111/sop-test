node {
  checkout scm
  env.PATH = "${tool 'jenkins-maven'}/bin:${env.PATH}"
  stage('Package Application') {
    sh 'mvn clean package -DskipTests'
  }

  stage('Create Docker Image') {
    docker.build("sop/docker-jenkins-pipeline:${env.BUILD_NUMBER}")
  }
}