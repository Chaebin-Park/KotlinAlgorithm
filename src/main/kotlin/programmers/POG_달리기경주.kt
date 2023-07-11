package programmers

import java.util.*

class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val runnerByRank = players.mapIndexed { index, s -> index to s }.toMap().toMutableMap()
        val runnerByName = players.mapIndexed { index, s -> s to index }.toMap().toMutableMap()

        callings.forEach { winner ->
            val winnerRank = runnerByName[winner]!!
            val loserRank = winnerRank - 1
            val loser = runnerByRank[loserRank]!!

            runnerByRank[loserRank] = winner
            runnerByRank[winnerRank] = loser

            runnerByName[winner] = loserRank
            runnerByName[loser] = winnerRank
        }

        return runnerByRank.values.toTypedArray()
    }
}

fun main() {
    val solution = Solution()
    val answer = solution.solution(
        arrayOf("mumu", "soe", "poe", "kai", "mine"),
        arrayOf("kai", "kai", "mine", "mine")
    )

    println(answer.contentToString())
}