def call(Map config = [:]) {
    // Map lets callers pass named options: myBuild(nodeVersion: '20', runLint: true)
    def nodeVersion = config.nodeVersion ?: '20'   // default to Node 20
    def runLint     = config.runLint     ?: true

    docker.image("node:${nodeVersion}-alpine").inside {
        stage('Install') {
            echo 'Install'
        }
        stage('Lint') {
            if (runLint) {
                echo 'run lint'
            }
        }
        stage('Build') {
            echo 'Build'
        }
    }
}