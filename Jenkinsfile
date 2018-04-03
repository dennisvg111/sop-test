node {
  docker.image('maven:3.3.3-jdk-8').inside {
    git url: "https://github.com/dennisvg111/sop-test.git"
    sh 'mvn -B clean install'
  }
}

