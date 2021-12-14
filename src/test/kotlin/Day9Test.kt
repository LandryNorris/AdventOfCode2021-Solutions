import Day8.Day8
import Day9.Day9
import org.junit.Test
import kotlin.test.assertEquals

class Day9Test {
    @Test
    fun testDay9() {
        //Run the code for the day here. For now, we will only run 1 day at a time.
        val day: BaseDay = Day9("data/Day9/Day9Test")
        assertEquals("15", day.part1())
        assertEquals("", day.part2())
    }
}