import Day4.Day4
import org.junit.Test
import kotlin.test.assertEquals

class Day4Test {
    @Test
    fun testDay4() {
        //Run the code for the day here. For now, we will only run 1 day at a time.
        val day: BaseDay = Day4("data/Day4/Day4Test")
        assertEquals("4512", day.part1())
        assertEquals("1924", day.part2())
    }
}