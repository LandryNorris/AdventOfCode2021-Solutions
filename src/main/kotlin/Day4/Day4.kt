package Day4

import BaseDay
import java.io.File

class Day4(filename: String): BaseDay() {
    private val contents = File(filename).readText().lines()

    private val draws = contents.first().split(',').map { it.toInt() }
    private val drawIterator = draws.iterator()

    //We want to get rid of the first line, since we already used it.
    private val bingoCards = contents.subList(1, contents.size).chunked(6).parseBingo()

    override fun part1(): String {
        var currentDraw = 0
        while(!bingoCards.any { it.isComplete() }) {
            currentDraw = drawIterator.next()
            bingoCards.forEach { it.makeMove(currentDraw) }
        }
        val winningCard = bingoCards.first { it.isComplete() }
        val sumUnmarked = winningCard.sumUnmarked()
        return (currentDraw*sumUnmarked).toString()
    }

    override fun part2(): String {
        var currentDraw = 0
        var winningCard: BingoCard? = null
        while(!bingoCards.all { it.isComplete() }) {
            currentDraw = drawIterator.next()
            bingoCards.forEach {
                val wasComplete = it.isComplete()
                it.makeMove(currentDraw)
                if(!wasComplete && it.isComplete()) winningCard = it
            }
        }
        val sumUnmarked = winningCard?.sumUnmarked() ?: return ""
        return (currentDraw*sumUnmarked).toString()
    }

    private fun List<List<String>>.parseBingo() =
        //For each chunk, we want to remove the first empty line, split by spaces, and parse
        map { chunk -> BingoCard(chunk.subList(1, chunk.size).map { line -> line.split(' ').mapNotNull { it.toIntOrNull() } }) }

    data class BingoCard(private val matrix: List<List<Int>>) {
        private val solved = matrix.map { it.map { false }.toMutableList() }.toMutableList()

        fun makeMove(number: Int) {
            val position = matrix.mapIndexed { index, row -> index to row.indexOfFirst { it == number } }.firstOrNull { it.second != -1 } ?: return
            solved[position.first][position.second] = true
        }

        fun sumUnmarked() = matrix.zip(solved)
            .sumOf { it.first.zip(it.second).sumOf { spot -> if(spot.second) 0 else spot.first } }

        fun isComplete(): Boolean {
            if(solved.any { row -> row.all { it } }) return true
            if(solved.mapIndexed { rowIndex, row -> row[rowIndex] }.all { it }) return true
            solved.first().indices.forEach { colIndex ->
                if(solved.all { row -> row[colIndex] }) return true
            }
            return false
        }
    }
}