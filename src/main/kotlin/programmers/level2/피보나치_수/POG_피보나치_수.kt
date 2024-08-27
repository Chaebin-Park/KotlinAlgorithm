package programmers.level2.피보나치_수

class Solution {
    fun solution(n: Int): Int {
        if (n <= 2) return 1
        val answer = IntArray(n + 1) {1}
        (3..n).forEach { answer[it] = (answer[it - 2] + answer[it - 1]) % 1234567 }
        return answer[n]
    }
}

fun main() {
    val solution = Solution()
    println(solution.solution(3))
    println(solution.solution(5))
}