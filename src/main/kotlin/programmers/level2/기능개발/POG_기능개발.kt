package programmers.level2.기능개발

import kotlin.math.ceil

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()

        val endDate = mutableListOf<Int>()

        progresses.forEachIndexed { index, progress ->
            val distributionDate = (ceil((100 - progress).toFloat() / speeds[index].toFloat())).toInt()
            endDate.add(distributionDate)
        }.let {
            var count = 0
            var max = Int.MIN_VALUE

            endDate.forEach { num ->
                if (num > max) {
                    if (count > 0) answer += count
                    count = 0
                    max = num
                }
                count++
            }

            if (count > 0) answer += count
        }

        return answer.toIntArray()
    }
}

/**
 *     val result = mutableListOf<Int>()
 *     var currentCount = 0
 *     var currentMax = Int.MIN_VALUE
 *
 *     input.forEach { number ->
 *         if (number > currentMax) {
 *             if (currentCount > 0) {
 *                 result += currentCount  // 이전 구간의 아이템 개수 저장
 *             }
 *             currentCount = 0  // 새로운 구간 시작
 *             currentMax = number
 *         }
 *         currentCount++  // 현재 구간의 아이템 개수 증가
 *     }
 *
 *     // 마지막 구간의 아이템 개수 저장
 *     if (currentCount > 0) {
 *         result += currentCount
 *     }
 *
 *     return result
 */

fun main() {
    val solution = Solution()
    val result1 = solution.solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
    println(result1.contentToString())
    val result2 = solution.solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1))
    println(result2.contentToString())

//    val f = 70f
//    val s = 30f
//    val test = ceil(f/s)
//    println(test)
}