import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

open class NiceClass {
    open fun method() {}
}

open class NiceClassImpl(value: Int = 0) : NiceClass() {

    constructor(a: Int, b: Int) : this(a * b)

    init {
        println("Value: $value")
    }

    var a = 0
        get() = field * 2
        set(value) {
            field = value * 2
        }

    val b: Int by lazy {
        println("b lazy init")
        value
    }

    override fun method() {
        // do something
    }

    companion object {
        const val PI = 3.1415926

        fun method2() {}
    }
}

interface NiceInterface {
    fun method() {
        1 * 1
    }
}

enum class NiceEnum {
    LEFT,
    RIGHT,
}

abstract class NiceAbstractClass {

}

class Topic4 {

    @Test
    fun `by lazy`() {
        val niceClass = NiceClassImpl(10, 10)
        niceClass.a = 5
        assertEquals(100, niceClass.b)
        assertEquals(20, niceClass.a)
        assertEquals(100, niceClass.b)
    }

    @Test
    fun `default value`() {
        Fan(
            "joao",
            Team.LION,
        )
    }

    @Test
    fun `methods in data class`() {
        val fan = Fan("joao", Team.OWL)
        fan.equals("")
        fan.toString()
        fan.hashCode()
        fan.copy()
    }

    @Test
    fun `string templates`() {
        val name = "danilo"
        println("Name: $name")
        println("Name: ${name.toUpperCase()} :D")

        val msg = """
            |Name:
            |$name
        """.trimIndent()
        println(msg)

        val info = """
            \info:
            \$name
        """.trimMargin("\\")
        println(info)
    }
}