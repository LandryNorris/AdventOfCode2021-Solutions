package Day6

import BaseDay
import java.io.File

class Day6(filename: String): BaseDay() {

    private val startingFish = File(filename).readText().split(',').mapNotNull { it.toIntOrNull() }.map { LanternFish(it) }

    override fun part1(): String {
        var currentFish = startingFish.map { it }

        for(i in 0 until 80) {
            val newList = ArrayList(currentFish)
            currentFish.forEach { it.runDay(newList) }
            currentFish = newList

            //println(currentFish.joinToString(separator = ", ") { it.internalTimer.toString() })
        }
        return currentFish.size.toString()
    }

    override fun part2(): String {
        var currentFish = startingFish.map { it }

        for(i in 0 until 256) {
            val newList = ArrayList(currentFish)
            currentFish.forEach { it.runDay(newList) }
            currentFish = newList

            //println(currentFish.joinToString(separator = ", ") { it.internalTimer.toString() })
        }
        return currentFish.size.toString()
    }

    class LanternFish(var internalTimer: Int) {
        fun runDay(list: ArrayList<LanternFish>) {
            if(internalTimer == 0) {
                internalTimer = 7
                list.add(LanternFish(8))
            }
            internalTimer--
        }
    }
}