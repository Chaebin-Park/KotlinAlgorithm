package programmers.level0.겹치는_선분의_길이

import java.util.*

class Solution {
    fun solution(lines: Array<IntArray>): Int {
        val flat = lines.flatMap { it.toList() }
        val totalLine = (flat.min()..flat.max()).associateWith { 0 }.toMutableMap()
//        val totalLine = (flat.minOf {it}..flat.maxOf {it}).associateWith { 0 }.toMutableMap() // 제출할땐 이렇게 해야 에러 안뜸

        lines.forEach { line -> (line.first()+1..line.last()).forEach { totalLine[it] = totalLine[it]!! + 1 } }

        return totalLine.count { it.value >= 2 }
    }
}

fun main() {
    val s = Solution()
    val result1 = s.solution(
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 5),
            intArrayOf(3, 9)
        )
    )
    println(result1)
    val result2 = s.solution(
        arrayOf(
            intArrayOf(-1, 1),
            intArrayOf(1, 3),
            intArrayOf(3, 9)
        )
    )
    println(result2)
    val result3 = s.solution(
        arrayOf(
            intArrayOf(0, 5),
            intArrayOf(3, 9),
            intArrayOf(1, 10)
        )
    )
    println(result3)
}