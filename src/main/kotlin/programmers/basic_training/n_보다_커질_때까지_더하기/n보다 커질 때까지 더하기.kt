package programmers.basic_training.n_보다_커질_때까지_더하기

class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var answer = 0

        numbers.forEach {
            if (answer > n) return answer
            answer += it
        }

        return answer
    }
}

fun main() {
    Solution().solution(intArrayOf(34, 5, 71, 29, 100, 34), 123).let(::println)
    Solution().solution(intArrayOf(58, 44, 27, 10, 100), 139).let(::println)
}

