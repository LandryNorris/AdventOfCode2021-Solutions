import Day8.Day8
import org.junit.Test
import kotlin.test.assertEquals

class Day8Test {
    @Test
    fun testDay8() {
        //Run the code for the day here. For now, we will only run 1 day at a time.
        val day: BaseDay = Day8("data/Day8/Day8Test")
        assertEquals("26", day.part1())
        assertEquals("", day.part2())
    }
}