package Day8

import BaseDay
import java.io.File

class Day8(filename: String): BaseDay() {
    private val patterns = File(filename).readLines().map { it.split('|').run { first().split(' ') to last().split(' ') } }
    private val outputs = patterns.map { it.second }
    private val knownNumbers = outputs.map {
        it.mapNotNull { pattern ->
            when(pattern.length) {
                2 -> 1
                3 -> 7
                4 -> 4
                7 -> 8
                else -> null
            }
        }
    }
    override fun part1(): String {
        return knownNumbers.sumOf { it.count() }.toString()
    }

    override fun part2(): String {
        return ""
    }
}