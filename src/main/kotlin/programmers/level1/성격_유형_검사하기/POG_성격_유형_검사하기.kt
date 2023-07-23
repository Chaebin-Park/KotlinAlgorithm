package programmers.level1.성격_유형_검사하기

class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val result = mutableMapOf("R" to 0, "T" to 0, "C" to 0, "F" to 0, "J" to 0, "M" to 0, "A" to 0, "N" to 0)
        val typePair = listOf( Pair("R", "T"), Pair("C", "F"), Pair("J", "M"), Pair("A", "N"))
        val scoreMap = mapOf(1 to 3, 2 to 2, 3 to 1, 5 to 1, 6 to 2, 7 to 3)

        choices.forEachIndexed { index, choice ->
            when {
                // 2번째 유형에 가산
                choice > 4 -> {
                    val type = survey[index][1].toString()
                    result[type] = result[type]!! + scoreMap[choice]!!
                }
                // 1번째 유형에 가산
                choice < 4 -> {
                    val type = survey[index][0].toString()
                    result[type] = result[type]!! + scoreMap[choice]!!
                }
            }
        }

        // 각 유형 쌍의 결과값 비교, 작은 쪽 유형 제거
        typePair.forEach { pair ->
            if (result[pair.first]!! >= result[pair.second]!!) {
                result.remove(pair.second)
            } else {
                result.remove(pair.first)
            }
        }

        // 결과
        return result.keys.joinToString("")
    }
}

fun main() {
    val solution = Solution()
    val result1 = solution.solution(
        arrayOf("AN", "CF", "MJ", "RT", "NA"),
        intArrayOf(5, 3, 2, 7, 5)
    )

    println(result1)

    val result2 = solution.solution(
        arrayOf("TR", "RT", "TR"),
        intArrayOf(7, 1, 3)
    )

    println(result2)
}