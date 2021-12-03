package Day3

import BaseDay
import bitArrayToInt
import filterIf
import java.io.File

class Day3(filename: String): BaseDay() {

    private val lines = File(filename).readText().lines().map { line -> line.toCharArray().map { it.digitToInt() } }
    private val bitValues = lines.first().mapIndexed { index, _ -> lines.map { it[index] } }
    private fun List<Int>.mostCommon() = if(count { it == 1 }.toDouble()/size >= count { it == 0 }.toDouble()/size) 1 else 0
    private fun List<Int>.leastCommon() = if(count { it == 1 }.toDouble()/size >= count { it == 0 }.toDouble()/size) 0 else 1

    override fun part1(): String {
        val gamma = bitValues.map { it.mostCommon() }.bitArrayToInt()
        val epsilon = bitValues.map { it.leastCommon() }.bitArrayToInt()

        return (gamma*epsilon).toString()
    }

    override fun part2(): String {
        val filteredMostCommon = filterEach(lines) { mostCommon() }
        val filteredLeastCommon = filterEach(lines) { leastCommon() }

        val o2Rating = filteredMostCommon.first().bitArrayToInt()
        val co2Rating = filteredLeastCommon.first().bitArrayToInt()
        return (o2Rating*co2Rating).toString()
    }

    private fun filterEach(original: List<List<Int>>, transform: List<Int>.() -> Int): List<List<Int>>  {
        var filteredMostCommon = original.map { it }
        bitValues.forEachIndexed { index, _ ->
            val mostCommonDigit = filteredMostCommon.map { it[index] }.transform()
            filteredMostCommon = filteredMostCommon.filter { it[index] == mostCommonDigit }
            if(filteredMostCommon.size == 1) return filteredMostCommon
        }
        return emptyList()
    }
}