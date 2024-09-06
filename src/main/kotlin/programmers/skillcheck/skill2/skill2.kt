package programmers.skillcheck.skill2

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val lost1 = lost.filter { !reserve.contains(it) }.sorted().toIntArray()
        val reserve1 = reserve.filter { !lost.contains(it) }.sorted().toMutableList()

        var result = n - lost1.size

        lost1.forEach { lostStudent ->
            if (reserve1.contains(lostStudent - 1)) {
                reserve1.remove(lostStudent - 1)
                result ++
            } else if (reserve1.contains(lostStudent + 1)) {
                reserve1.remove(lostStudent + 1)
                result ++
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution()
    println(solution.solution(5, intArrayOf(2,4), intArrayOf(1,3,5)))
    println(solution.solution(5, intArrayOf(2,4), intArrayOf(3)))
    println(solution.solution(3, intArrayOf(3), intArrayOf(1)))
}
/**
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]	4
 * 3	[3]	[1]	2
 */