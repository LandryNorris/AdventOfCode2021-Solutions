import Day5.Day5
import Day7.Day7
import org.junit.Test
import kotlin.test.assertEquals

class Day7Test {
    @Test
    fun testDay7() {
        //Run the code for the day here. For now, we will only run 1 day at a time.
        val day: BaseDay = Day7("data/Day7/Day7Test")
        assertEquals("37", day.part1())
        assertEquals("168", day.part2())
    }
}