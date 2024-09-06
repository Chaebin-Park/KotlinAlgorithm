package programmers.skillcheck2.test2

import kotlin.math.sqrt

class Solution {
    fun solution(numbers: String): Int {
        var answer = 0
        val split = numbers.split("").filter { !it.isEmpty() }
        (1..split.size).forEach { digit ->
            var combination = ""
            split.forEach {

            }
        }

        return answer
    }

    fun isPrime(num: Int): Boolean {
        if(num<=1) return false

        (2..sqrt(num.toDouble()).toInt()).forEach {
            if(num%it==0){
                return false
            }
        }

        return true
    }
}

fun main() {
    val solution = Solution()
    solution.solution("17")
    solution.solution("011")
}