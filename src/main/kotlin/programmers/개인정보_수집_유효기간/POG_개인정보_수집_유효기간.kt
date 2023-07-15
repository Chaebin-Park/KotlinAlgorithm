package programmers.개인정보_수집_유효기간

import java.time.LocalDate
import java.time.format.DateTimeFormatter


class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = ArrayList<Int>()

        val todayFormattedDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"))
        val termMap = terms.associate { it.split(" ").let { (code, term) ->
            code to term.toInt()
        } }

        privacies.forEachIndexed { index, privacy ->
            privacy.split(" ").let { (startDate, term) ->
                val startFormattedDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"))
                val expiredFormattedDate = startFormattedDate.plusMonths(termMap[term]!!.toLong())
                if (!expiredFormattedDate.isAfter(todayFormattedDate)) {
                    answer.add(index + 1)
                }
            }
        }
        return answer.toIntArray()
    }
}

fun main() {
    val solution = Solution()
    val result = solution.solution(
        "2022.05.19",
        arrayOf("A 6", "B 12", "C 3"),
        arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
    )

    println(result.contentToString())
    println()

    val result1 = solution.solution(
        "2020.01.01",
        arrayOf("Z 3", "D 5"),
        arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")
    )

    println(result1.contentToString())
}