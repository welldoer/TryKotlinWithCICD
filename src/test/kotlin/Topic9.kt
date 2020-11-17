import org.junit.jupiter.api.Test
import java.lang.ArithmeticException
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Topic9 {

    @Test
    fun test() {
        assertTrue {
            get(2)
        }

        assertFalse {
            get("")
        }

        assertTrue {
            get(1L)
        }
    }

    private fun get(x: Any) =
        when (x) {
            is String -> {
                println("String: ${x.toUpperCase()}")
                false
            }
            is Int -> {
                println("Int: ${x.plus(1)}")
                false
            }
            is Long -> {
                println("Long: ${x.minus(10)}")
                true
            }
            else -> false
        }

    private fun get(x: Int) =
        if (x % 2 == 0) {
            println("true")
            true
        } else {
            println("false")
            false
        }

    private fun get(x: String) =
        try {
            2 / x.length
            true
        } catch (e: ArithmeticException) {
            println("Error!")
            false
        }

    @Test
    fun `other example about infix`() {
        println(mapOf(1 to "a"))
    }
}