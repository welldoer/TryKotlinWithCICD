import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Topic2 {
    @Test
    fun `type inference`() {
        val a: Int = 1    // it's not necessary
        val b = 2
        val c = "this is a string"

        assertTrue(a is Int)
        assertTrue(b is Int)
        assertTrue(c is String)
    }

    @Test
    fun `mutable and immutable variables`() {
        val a = 1    // immutable
        var b = 2    // mutable

        // a += 1    // val cannot be reassigned
        b += 1

        assertEquals(a, 1)
        assertEquals(b, 3)
    }

}