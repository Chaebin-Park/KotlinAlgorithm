package programmers.skillcheck.skill1

class Solution {
    fun solution(arr: IntArray): IntArray {
        val min = arr.minOf { it }
        val answer = arr.filter { it != min }.toIntArray()
        return if (answer.isEmpty()) intArrayOf(-1) else answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.solution(intArrayOf(4,3,2,1)).contentToString())
    println(solution.solution(intArrayOf(10)).contentToString())
}