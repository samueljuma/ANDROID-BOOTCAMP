package gettingcracked.solidprinciples.ocp

interface Notification{
    fun send(message: String)
}


class SMSNotification: Notification{
    override fun send(message: String) {}
}

class EmailNotification: Notification{
    override fun send(message: String) {}
}

class NotificationService(
    private val notification: Notification
){
    fun send(message: String){
        notification.send(message)
    }
}