package programmers.부족한_금액_계산하기

class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var loop = 0L
        (1..count).forEach { loop += it }
        val total = price * loop
        return if(money - total < 0) {
            total - money
        } else {
            0
        }
    }

    fun solution1(price: Int, money: Int, count: Int): Long
            = (1..count).sumOf { it * price.toLong() }.let { if (money > it) 0 else it - money }
}

fun main() {
    val solution = Solution()

    val result1 = solution.solution(3, 20, 4)
    println(result1)
}