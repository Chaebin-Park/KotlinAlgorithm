class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer = ArrayList<Int>()
        var keys = ""
        keymap.forEach { keys += it }
        val keySet = keys.toSet()
        val keyCountMap: MutableMap<Char, Int> = keySet.associateWith { 0 }.toMap().toMutableMap()

        keyCountMap.keys.forEach keys@ { key ->
            var index = 101
            keymap.forEach inner@ { command ->
                val tmp = command.indexOf(key).coerceAtMost(index).takeIf { it >= 0 } ?: return@inner
                index = tmp.coerceAtMost(index)
            }
            keyCountMap[key] = index + 1
        }

        targets.forEach { target ->
            var result = 0
            target.forEach { key -> result += keyCountMap[key] ?: Int.MIN_VALUE }
            answer.add(result.takeIf { it > 0 } ?: -1)
        }

        return answer.toIntArray()
    }
}

fun main() {
    val solution = Solution()
    val result1 = solution.solution(
        arrayOf("ABCDE"),
        arrayOf("FGHIJ")
    )
    println(result1.contentToString())

    val result2 = solution.solution(
        arrayOf("ABCE"),
        arrayOf("ABDE")
    )
    println(result2.contentToString())

    val result3 = solution.solution(
        arrayOf("AGZ", "BSSS"),
        arrayOf("ASA","BGZ")
    )
    println(result3.contentToString())
}