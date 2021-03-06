package Day1

import BaseDay
import java.io.File

class Day1(filename: String): BaseDay() {
    private val values = arrayListOf<Int>()

    init {
        values.clear()
        val fileValues = File(filename).readText().lines().mapNotNull { it.toIntOrNull() }
        values.addAll(fileValues)
    }

    override fun part1(): String {
        val numIncreased = values.windowed(2).count { it.last() > it.first() }
        return numIncreased.toString()
    }

    override fun part2(): String {
        val windowSums = values.windowed(3).map { it.sum() }
        val numIncreased = windowSums.windowed(2).count { it.last() > it.first() }
        return numIncreased.toString()
    }
}