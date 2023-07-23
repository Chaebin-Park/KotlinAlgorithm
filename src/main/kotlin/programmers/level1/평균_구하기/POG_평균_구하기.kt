package programmers.level1.평균_구하기

class Solution {
    fun solution(arr: IntArray): Double = arr.average()

    fun solution1(arr: IntArray): Double = (arr.fold(0) {acc, i -> acc + i}.toDouble() / arr.size)
}

fun main() {
    val solution = Solution()
    println(solution.solution(intArrayOf(1, 2, 3, 4)))
    println(solution.solution(intArrayOf(5, 5)))
}