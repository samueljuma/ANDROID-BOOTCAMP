package gettingcracked.solidprinciples.isp

interface Powerable {
    fun turnOn()
    fun turnOff()
}

interface MediaPlayer{
    fun play()
}

interface Telephony{
    fun makeCall()
}

class SmartTv: Powerable, MediaPlayer{
    override fun turnOn() {}
    override fun turnOff() {}
    override fun play() {}
}

class SmartPhone: Powerable, MediaPlayer, Telephony{
    override fun turnOn() {}
    override fun turnOff() {}
    override fun play() {}
    override fun makeCall() {}
}