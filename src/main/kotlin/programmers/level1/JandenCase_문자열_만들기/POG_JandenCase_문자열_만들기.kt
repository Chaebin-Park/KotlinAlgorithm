package programmers.level1.JandenCase_문자열_만들기

class Solution {
    fun solution(s: String): String = s.split(" ").joinToString(" ") { word -> word.lowercase().replaceFirstChar { c -> c.uppercase() } }
}

fun main() {
    val solution = Solution()
    println(solution.solution("3people unFollowed me"))
    println(solution.solution("for the last week"))
}