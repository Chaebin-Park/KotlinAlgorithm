package programmers.level1.최댓값과_최솟값

class Solution {
    fun solution(s: String): String = s.split(" ").map { it.toInt() }.let { map -> "${map.minOf{it}} ${map.maxOf{it}}" }
}

fun main() {
    val solution = Solution()
    println(solution.solution("1 2 3 4"))
    println(solution.solution("-1 -2 -3 -4"))
    println(solution.solution("-1 -1"))
}