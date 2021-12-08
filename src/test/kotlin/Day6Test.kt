import Day6.Day6
import org.junit.Test
import kotlin.test.assertEquals

class Day6Test {
    @Test
    fun testDay6() {
        val day = Day6("data/Day6/Day6Test")
        assertEquals("5934", day.part1())
        assertEquals("26984457539", day.part2())
    }
}