package programmers.level0.정수를_나선형으로_배치하기

import java.util.ArrayList

class Solution {
    fun solution(n: Int): Array<IntArray> {
        var answer: Array<IntArray> = arrayOf()
        val spiral = ArrayList<Int>()
        val direction = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )
        // answer 크기 설정
        (0 until n).forEach { _ -> answer += IntArray(n) }

        var input = n
        spiral.add(input)
        while (input > 1) {
            input -= 1
            spiral.add(input)
            spiral.add(input)
        }
        var count = 0
        var x = -1
        var y = 0

        (0 until   spiral.size).forEach {  i ->
            (0 until  spiral[i]).forEach { _ ->
                println(i)
                y += direction[i % 4][0]
                x += direction[i % 4][1]
                count += 1
                answer[y][x] = count
            }
        }

        return answer
    }
}

fun main() {
    val solution = Solution()
    val result1 = solution.solution(4)
    result1.forEach { println(it.contentToString()) }

    val result2 = solution.solution(5)
    result2.forEach { println(it.contentToString()) }
}