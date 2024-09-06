package programmers.basic_training.이진_변환_반복하기

class Solution {
    fun solution(s: String): IntArray {
        var string = s
        var zeroCount = 0
        var cycle = 0

        while (string != "1") {
            zeroCount += string.count { it == '0' }
            string = string.filter { it != '0' }
            string = string.length.toString(2)
            cycle ++
        }

        return intArrayOf(cycle, zeroCount)
    }
}
fun main() {
    Solution().solution("110010101001")
    Solution().solution("01110")
    Solution().solution("1111111")
}