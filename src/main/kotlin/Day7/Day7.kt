package Day7

import BaseDay
import java.io.File
import kotlin.math.abs

class Day7(filename: String): BaseDay() {
    val positions = File(filename).readText().split(",").mapNotNull { it.toIntOrNull() }
    val max = positions.maxOrNull() ?: 0

    override fun part1(): String {
        val minFuelUsage = (0 .. max).minOf { target ->
            val fuelUsed = positions.map { abs(it - target) }
            fuelUsed.sum()
        }
        return minFuelUsage.toString()
    }

    override fun part2(): String {
        val minFuelUsage = (0 .. max).minOf { target ->
            val fuelUsed = positions.map { fuelUsed(it, target) }
            fuelUsed.sum()
        }
        return minFuelUsage.toString()
    }

    fun fuelUsed(start: Int, end: Int): Int {
        val distance = abs(end-start)
        return (0..distance).sum()
    }
}