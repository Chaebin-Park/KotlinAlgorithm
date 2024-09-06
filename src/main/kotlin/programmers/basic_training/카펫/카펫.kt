package programmers.basic_training.카펫

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        (1..yellow).forEach { horizontal ->
            if (yellow % horizontal != 0) return@forEach
            val vertical = yellow / horizontal
            if (horizontal >= vertical) {
                val check = horizontal * 2 + vertical * 2 + 4
                if (check == brown) {
                    return intArrayOf(horizontal + 2, vertical + 2)
                }
            }
        }

        return (1 .. yellow)
            .filter { yellow % it == 0 }
            .first { brown == (yellow / it * 2) + (it * 2) + 4 }
            .let { intArrayOf(yellow / it + 2, it + 2) }

//        return intArrayOf()
    }
}

fun main() {
    Solution().solution(10, 2).contentToString().let(::println)
    println()
    Solution().solution(8, 1).contentToString().let(::println)
    println()
    Solution().solution(24, 24).contentToString().let(::println)
}