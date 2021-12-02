import Day1.Day1
import Day2.Day2
import org.junit.Test
import kotlin.test.assertEquals

class Day2Test {
    @Test
    fun testDay2() {
        //Run the code for the day here. For now, we will only run 1 day at a time.
        val day: BaseDay = Day2("data/Day2/Day2Test")
        assertEquals("150", day.part1())
        assertEquals("900", day.part2())
    }
}