package programmers.level1.없는_숫자_더하기

class Solution {
    fun solution(numbers: IntArray): Int {
        val zero2nine = mutableListOf(0,1,2,3,4,5,6,7,8,9)
        return numbers.forEach { number -> zero2nine.remove(number) }.let { zero2nine.sum() }
    }

    fun solution1(numbers: IntArray): Int = (0..9).filterNot(numbers::contains).sum()

    fun solution2(numbers: IntArray): Int  = 45 - numbers.sum()

}

fun main() {
    val numbers1 = intArrayOf(1,2,3,4,6,7,8,0)
    val numbers2 = intArrayOf(5,8,4,0,6,7,9)

    var solution = Solution()

    println(solution.solution(numbers1))

    println(solution.solution(numbers2))
}