echo "Beer Driven Development Workflow"

stage 'ui-build'
node {
    git 'https://github.com/aosn/beer-driven-development.git'
    sh 'cd ui'
    sh 'chmod u+x ./gradlew'
    sh './gradlew clean jar'
    archive 'build/libs/*.jar'
}
