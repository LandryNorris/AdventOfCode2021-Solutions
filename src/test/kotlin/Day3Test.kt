import Day1.Day1
import Day3.Day3
import org.junit.Test
import kotlin.test.assertEquals

class Day3Test {
    @Test
    fun testDay3() {
        //Run the code for the day here. For now, we will only run 1 day at a time.
        val day: BaseDay = Day3("data/Day3/Day3Test")
        assertEquals("198", day.part1())
        assertEquals("230", day.part2())
    }
}