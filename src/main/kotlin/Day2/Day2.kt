package Day2

import BaseDay
import java.io.File

class Day2(filename: String): BaseDay() {
    private val instructions = arrayListOf<Pair<Direction, Int>>()

    init {
        instructions.clear()
        val fileInstructions = File(filename).readText().lines().map { it.split(" ").run { first().toDirection() to last().toInt() } }
        instructions.addAll(fileInstructions)
    }

    override fun part1(): String {
        var depth = 0
        var x = 0
        instructions.forEach {
            when(it.first) {
                is Direction.Forward -> x += it.second
                is Direction.Down -> depth += it.second
                is Direction.Up -> depth -= it.second
            }
        }
        return (x*depth).toString()
    }

    override fun part2(): String {
        var depth = 0
        var x = 0
        var aim = 0

        instructions.forEach {
            when(it.first) {
                is Direction.Forward -> {
                    x += it.second
                    depth += aim*it.second
                }
                is Direction.Down -> aim += it.second
                is Direction.Up -> aim -= it.second
            }
        }
        return (depth*x).toString()
    }

    sealed class Direction {
        object Forward: Direction()
        object Down: Direction()
        object Up: Direction()

    }

    private fun String.toDirection() = when(this) {
        "forward" -> Direction.Forward
        "up" -> Direction.Up
        "down" -> Direction.Down
        else -> error("$this is not a valid direction")
    }
}