import Day5.Day5
import org.junit.Test
import kotlin.test.assertEquals

class Day5Test {
    @Test
    fun testDay5() {
        //Run the code for the day here. For now, we will only run 1 day at a time.
        val day: BaseDay = Day5("data/Day5/Day5Test")
        assertEquals("5", day.part1())
        assertEquals("12", day.part2())
    }
}