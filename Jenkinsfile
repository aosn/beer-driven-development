echo "Beer Driven Development Workflow"

stage 'ui-build'
node {
    git 'https://github.com/aosn/beer-driven-development.git'
    sh 'chmod u+x ./gradlew'
    sh './gradlew jar'
    archive 'build/libs/*.jar'
}
