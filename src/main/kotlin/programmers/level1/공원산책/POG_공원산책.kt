package programmers.level1.공원산책

class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var y = park.indexOfFirst { it.contains('S') }
        var x = park[y].indexOf('S')

        routes.forEach { route ->
            val sep = route.split(" ")
            val direction = sep[0]
            val distance = sep[1].toInt()

            when (direction) {
                // 열 이동
                "S" ->  if (checkY(park, y, y+distance, x)) y += distance
                "N" ->  if (checkY(park, y-distance, y, x)) y -= distance
                // 행 이동
                "E" ->  if (checkX(park, x, x+distance, y))  x += distance
                "W" ->  if (checkX(park, x-distance, x, y))  x -= distance
            }
        }

        return intArrayOf(y, x)
    }

    private fun checkX(park: Array<String>, startX: Int, targetX: Int, y: Int) = startX >= 0 && targetX < park[0].length && (startX .. targetX).all { x -> park[y][x] != 'X' }

    private fun checkY(park: Array<String>, startY: Int, targetY: Int, x: Int) = startY >= 0 && targetY < park.size && (startY .. targetY).all { y -> park[y][x] != 'X' }
}

fun main() {
    val solution = Solution()

    val answer1 = solution.solution(
        arrayOf("SOO","OOO","OOO"),
        arrayOf("E 2","S 2","W 1")
    )

    println(answer1.contentToString())
    println("******************************")

    val answer2 = solution.solution(
        arrayOf("SOO","OXX","OOO"),
        arrayOf("E 2","S 3","W 1")
    )

    println(answer2.contentToString())
    println("******************************")

    val answer3 = solution.solution(
        arrayOf("OSO","OOO","OXO","OOO"),
        arrayOf("E 2","S 3","W 1")
    )

    println(answer3.contentToString())
    println("******************************")
}

