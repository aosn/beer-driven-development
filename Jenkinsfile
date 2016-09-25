echo "Beer Driven Development Workflow"

stage 'ui-build'
node {
    git 'https://github.com/aosn/beer-driven-development.git'
    sh 'chmod u+x ./frontend-javafx/gradlew'
    sh 'cd frontend-javafx && ./gradlew clean jar'
    archive 'frontend-javafx/build/libs/*.jar'
}
