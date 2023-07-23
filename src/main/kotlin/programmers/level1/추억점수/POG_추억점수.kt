package programmers.level1.추억점수

class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val answer = ArrayList<Int>()

        val memoryMap = name.mapIndexed { index, s -> s to yearning[index] }.toMap()

        photo.forEach photo@ {people ->
            var memorySum: Int = 0
            people.forEach people@ { person ->
                memorySum += memoryMap[person] ?: 0
            }
            answer.add(memorySum)
            memorySum = 0
        }

        return answer.toIntArray()
    }
}

class Solution1 {
    fun solution(names: Array<String>, yearnings: IntArray, photoes: Array<Array<String>>): IntArray {
        val map = names.zip(yearnings.toTypedArray()).toMap()
        return photoes.map { photo -> photo.sumOf { map[it] ?: 0 } }.toIntArray()
    }
}

fun main() {
    val solution = Solution()
    val result = solution.solution(
        arrayOf("may", "kein", "kain", "radi"),
        intArrayOf(5, 10, 1, 3),
        arrayOf(arrayOf("may"), arrayOf("kein", "deny", "may"), arrayOf("kon", "coni")),
    )

    println(result.contentToString())
}