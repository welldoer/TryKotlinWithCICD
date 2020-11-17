import java.util.*

data class Fan(
    val name: String,
    val team: Team,
    val id: String = UUID.randomUUID().toString(),
    var nickname: String = "",
)

enum class Team {
    SHARK,
    LION,
    OWL,
}

fun main(args: Array<String>) {
    val fan = getAnyFan()

    print(fan)
}

fun getAnyFan() = Fan("fan", Team.SHARK)