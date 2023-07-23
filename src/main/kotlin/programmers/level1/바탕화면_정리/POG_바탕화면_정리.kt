package programmers.level1.바탕화면_정리

class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        val answer = intArrayOf(wallpaper.size, wallpaper[0].length, 0, 0)

        wallpaper.forEachIndexed { rowIndex, rowItem ->
            rowItem.forEachIndexed { columnIndex, columnItem ->
                if (columnItem == '#') {
                    answer[0] = answer[0].coerceAtMost(rowIndex)
                    answer[1] = answer[1].coerceAtMost(columnIndex)
                    answer[2] = answer[2].coerceAtLeast(rowIndex + 1)
                    answer[3] = answer[3].coerceAtLeast(columnIndex + 1)
                }
            }
        }

        return answer
    }
}

fun main() {
    val solution = Solution()
    val result1 = solution.solution(arrayOf(".#...", "..#..", "...#."))
    println(result1.contentToString())
    val result2 = solution.solution(arrayOf("..........", ".....#....", "......##..", "...##.....", "....#....."))
    println(result2.contentToString())
    val result3 = solution.solution(arrayOf(".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."))
    println(result3.contentToString())
    val result4 = solution.solution(arrayOf("..", "#."))
    println(result4.contentToString())
}