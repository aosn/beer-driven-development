echo "Beer Driven Development Workflow"

stage 'ui-build'
node {
    git 'https://github.com/aosn/beer-driven-development.git'
    sh 'chmod u+x ./cd/gradlew'
    sh 'cd ui && ./gradlew clean jar'
    archive 'ui/build/libs/*.jar'
}
