import Day1.Day1
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test {
    @Test
    fun testDay1() {
        //Run the code for the day here. For now, we will only run 1 day at a time.
        val day: BaseDay = Day1("data/Day1/Day1Test")
        assertEquals("7", day.part1())
        assertEquals("5", day.part2())
    }
}