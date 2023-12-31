fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    client?.personalInfo?.email?.let { email ->
        message?.let {
            mailer.sendMessage(email, it)
        }
    }
}

fun sendMessageToClient1(client: Client?, message: String?, mailer: Mailer) {
    val email: String? = client?.personalInfo?.email
    if (email != null && message != null) mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}
