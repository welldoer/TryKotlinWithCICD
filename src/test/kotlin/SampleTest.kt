import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SampleTest {
    @Test
    fun sample() {
        assertEquals(8, Sample().calc(3, 5))
    }
}