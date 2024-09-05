package programmers.level2.n2_배열_자르기

class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = IntArray((right - left).toInt() + 1)
        var index = left

        answer.forEachIndexed { i, _ ->
            val raw = (index / n.toLong()).toInt()
            val column = (index % n.toLong()).toInt()
            answer[i] = raw.coerceAtLeast(column) + 1
            index ++
        }

        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.solution(3, 2, 5).contentToString())
    println(solution.solution(4, 7, 14).contentToString())
}