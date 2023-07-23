package programmers.level0.옹알이_1

class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        babbling.forEach { bab ->
            val split = bab.split("aya", "ye", "woo", "ma")
            if (split.none { it.isNotEmpty() }) answer += 1
        }
        return answer
    }

    fun solution1(babbling: Array<String>): Int =
        babbling.map { it.replace("aya|ye|woo|ma".toRegex(), "") }.count { it.isEmpty() }
}

fun main() {
    val solution = Solution()
    val result1 = solution.solution(arrayOf("aya", "yee", "u", "maa", "wyeoo"))
    println(result1)
    println("___________________")
    val result2 = solution.solution(arrayOf("ayaye", "uuuma", "ye", "yemawoo", "ayaa"))
    println(result2)
}