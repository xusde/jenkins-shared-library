// 'call' is the special method name — it runs when you call notifySlack() in a Jenkinsfile
def call(String status) {
    def color = 'danger'
    def emoji = ':x:'
    def target_slack_chanel = '#slack-notifications'
    if (status == 'success') {
        color = 'good'
        emoji = ':white_check_mark:'
    } else if (status == 'unstable') {
        color = 'warning'
        emoji = ':warning:'
    }

    slackSend(
            channel: target_slack_chanel,
            color: color,
            message: """
            *Build ${status}* ${emoji}
            Job: `${env.JOB_NAME}` | Build: #${env.BUILD_NUMBER}
            Branch: `${env.GIT_BRANCH}`
            <${env.BUILD_URL}|View logs>
        """
    )
}
