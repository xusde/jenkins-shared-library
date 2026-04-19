// 'call' is the special method name — it runs when you call notifySlack() in a Jenkinsfile
def call(String status) {
    def color = 'danger'
    def emoji = ':x:'

    if (status == 'success') {
        color = 'good'
        emoji = ':white_check_mark:'
    } else if (status == 'unstable') {
        color = 'warning'
        emoji = ':warning:'
    }

    slackSend(
            channel: '#jenkins-builds',
            color: color,
            message: """
            *Build ${status}* ${emoji}
            Job: `${env.JOB_NAME}` | Build: #${env.BUILD_NUMBER}
            Branch: `${env.GIT_BRANCH}`
            <${env.BUILD_URL}|View logs>
        """
    )
}