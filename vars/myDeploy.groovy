def call(String environment) {
    stage("Deploy to ${environment}") {
        echo 'deploy stage'
        if (environment == 'prd') {
            // require manual approval before deploying to prod
            echo 'deploy to prd'
            input message: "Deploy to production?", ok: 'Yes, ship it!'
        }
    }
}