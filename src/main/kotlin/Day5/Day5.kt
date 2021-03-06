package Day5

import BaseDay
import java.io.File
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

class Day5(filename: String): BaseDay() {
    private val lines = File(filename).readText().lines().map { line -> line.split(" -> ").map { pair -> pair.split(',').mapNotNull { it.toIntOrNull() }.toPoint() }.toLine() }
    private val hvLines = lines.filter { it.start.x == it.end.x || it.start.y == it.end.y }
    private val mapSize = lines.maxOfOrNull { max(it.maxX, it.maxY) } ?: 0

    override fun part1(): String {
        val map = HashMap<Point, Int>()
        for(i in 0 .. mapSize) {
            for(j in 0 .. mapSize) {
                hvLines.forEach { line ->
                    val point = Point(j, i)
                    if(line.contains(point)) map[point] = (map[point] ?: 0) + 1
                }
            }
        }
        return map.values.count { it >= 2 }.toString()
    }

    override fun part2(): String {
        val map = HashMap<Point, Int>()
        for(i in 0 .. mapSize) {
            for(j in 0 .. mapSize) {
                lines.forEach { line ->
                    val point = Point(j, i)
                    if(line.contains(point)) map[point] = (map[point] ?: 0) + 1
                }
            }
        }
        return map.values.count { it >= 2 }.toString()
    }

    private fun List<Int>.toPoint(): Point {
        assert(size == 2)
        return Point(first(), last())
    }

    private fun List<Point>.toLine(): Line {
        assert(size == 2)
        return Line(first(), last())
    }

    data class Point(val x: Int, val y: Int) {
        private fun distanceSquared(other: Point): Int {
            return (x-other.x)*(x-other.x) + (y-other.y)*(y-other.y)
        }

        fun distance(other: Point): Double = sqrt(distanceSquared(other).toDouble())

        override fun toString(): String {
            return "($x, $y)"
        }
    }

    data class Line(val start: Point, val end: Point) {
        val slope = (end.y-start.y)/(end.x-start.x).toDouble()

        private fun collinear(point: Point): Boolean {
            //check horizontal and vertical
            if(start.x == end.x) return point.x == start.x
            if(start.y == end.y) return point.y == start.y
            val a = (point.y-start.y)/(end.y-start.y).toDouble()
            val b = (point.x-start.x)/(end.x-start.x).toDouble()
            return abs(a-b) < 0.001 //we want to avoid floating point error, so we check that it's "close enough".
        }

        fun contains(point: Point): Boolean {
            return within(point) && collinear(point)
        }

        private fun within(point: Point): Boolean {
            return point.x in minX..maxX && point.y in minY..maxY
        }

        val minX by lazy { min(start.x, end.x) }
        val minY by lazy { min(start.y, end.y) }
        val maxX by lazy { max(start.x, end.x) }
        val maxY by lazy { max(start.y, end.y) }

        override fun toString(): String {
            return "($start, $end)"
        }
    }
}