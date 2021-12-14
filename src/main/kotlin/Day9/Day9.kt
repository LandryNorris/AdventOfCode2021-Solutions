package Day9

import BaseDay
import java.io.File

class Day9(filename: String): BaseDay() {
    private val map = File(filename).readLines().map { line -> line.map { char -> char.digitToInt() } }

    override fun part1(): String {
        val booleanMap = map.mapIndexed { rowIndex, row -> row.mapIndexed { colIndex, value ->
            val lowestByRowNeighbors = when (colIndex) {
                0 -> value < row[colIndex+1]
                row.size-1 -> value < row[colIndex-1]
                else -> value < row[colIndex+1] && value < row[colIndex-1]
            }

            val lowestByColNeighbors = when (rowIndex) {
                0 -> value < map[rowIndex+1][colIndex]
                map.size-1 -> value < map[rowIndex-1][colIndex]
                else -> value < map[rowIndex-1][colIndex] && value < map[rowIndex+1][colIndex]
            }

            lowestByRowNeighbors && lowestByColNeighbors
        } }
        val lowestMap = map.zip(booleanMap).map { row -> row.first.zip(row.second).map { if(it.second) it.first else null } }
        val riskMap = lowestMap.map { row -> row.map { it?.plus(1) } }
        val riskSum = riskMap.sumOf { row -> row.sumOf { it ?: 0 } }
        return riskSum.toString()
    }

    override fun part2(): String {
        return ""
    }
}