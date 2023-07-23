package programmers.level1.나머지가_1이_되는_수_찾기

class Solution {
    private fun smallestDivisor(n: Int): Int {
        (2 .. n).forEach { if (n % it == 0) return it }
        return 1
    }

    fun solution(n: Int): Int = smallestDivisor(n - 1)

    fun solution1(n: Int) = (1..n).first { n % it == 1 }
}

fun main() {
    val solution = Solution()
    println(solution.solution(10))
    println(solution.solution(12))
}