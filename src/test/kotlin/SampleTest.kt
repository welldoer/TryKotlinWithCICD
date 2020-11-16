import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SampleTest {
    @Test
    fun sample() {
        assertEquals(8, Sample().sum(3, 5))
    }
}