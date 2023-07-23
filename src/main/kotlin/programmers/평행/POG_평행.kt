package programmers.평행

import kotlin.math.abs

class Solution {
    private fun calc(dot1: IntArray, dot2: IntArray): Float {
        val diffX = abs(dot1[0] - dot2[0]).toFloat()
        val diffY = abs(dot1[1] - dot2[1]).toFloat()
        return diffY / diffX
    }

    fun solution(dots: Array<IntArray>): Int {
        // 01 / 23
        if (calc(dots[0], dots[1]) == calc(dots[2], dots[3])) return 1

        // 02 / 13
        if (calc(dots[0], dots[2]) == calc(dots[1], dots[3])) return 1

        // 03 / 12
        if (calc(dots[0], dots[3]) == calc(dots[1], dots[2])) return 1

        return 0
    }
}

fun main() {
    val solution = Solution()
    val result1 = solution.solution(
        arrayOf(
            intArrayOf(1, 4),
            intArrayOf(9, 2),
            intArrayOf(3, 8),
            intArrayOf(11, 6)
        )
    )
    println(result1)

    val result2 = solution.solution(
        arrayOf(
            intArrayOf(3, 5),
            intArrayOf(4, 1),
            intArrayOf(2, 4),
            intArrayOf(5, 10)
        )
    )
    println(result2)
}