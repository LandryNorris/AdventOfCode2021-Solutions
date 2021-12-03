import Day1.Day1
import Day2.Day2
import Day3.Day3

fun main() {
    //Run the code for the day here. For now, we will only run 1 day at a time.
    val day: BaseDay = Day3("data/Day3/Day3Data")

    println("Part 1: ${day.part1()}")
    println("Part 2: ${day.part2()}")
}