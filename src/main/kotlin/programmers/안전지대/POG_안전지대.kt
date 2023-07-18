package programmers.안전지대

class Solution {
    fun solution(board: Array<IntArray>): Int {
        var answer: Int = 0
        val xMax = board[0].size - 1
        val yMax = board.size - 1
        val copyBoard = Array(board.size) { IntArray(board[0].size) }

        board.forEachIndexed y@ { y, spaces ->
            spaces.forEachIndexed x@ { x, space ->
                if (space != 1) return@x
                copyBoard[y][x] = 1
                if (y + 1 <= yMax)                  copyBoard[y + 1][x] = 1 // 아래쪽 한칸
                if (x - 1 >= 0 && y + 1 <= yMax)    copyBoard[y + 1][x - 1] = 1  // 좌하단 한칸
                if (x + 1 <= xMax && y + 1 <= yMax) copyBoard[y + 1][x + 1] = 1  // 우하단 한칸

                if (x - 1 >= 0)                     copyBoard[y][x - 1] = 1 // 왼쪽 한칸
                if (x + 1 <= xMax)                  copyBoard[y][x + 1] = 1 // 오른쪽 한칸

                if (y - 1 >= 0)                     copyBoard[y - 1][x] = 1 // 위쪽 한칸
                if (x - 1 >= 0 && y - 1 >= 0)       copyBoard[y - 1][x - 1] = 1  // 좌상단 한칸
                if (x + 1 <= xMax && y - 1 >= 0)    copyBoard[y - 1][x + 1] = 1  // 우상단 한칸
            }
        }

        copyBoard.forEach { spaces ->
            answer += spaces.count { it == 0 }
        }

        return answer
    }

    fun solution1(board: Array<IntArray>): Int {
        val pointList = board.mapIndexed { i, arr -> arr.mapIndexed { j, bool -> arrayOf(i,j, 0) } }.flatten()
        val boomList = board.mapIndexed { i, arr -> arr.mapIndexed { j, bool -> arrayOf(i,j,bool) }.filter { it[2] == 1 } }.flatten()

        return pointList.map{ point -> boomList.map{ boom->
            if( kotlin.math.abs(point[0] - boom[0]) <2 && kotlin.math.abs(point[1] - boom[1]) <2) {
                point[2] = 1
            }
        }
            point
        }.filter { it->  it[2] ==0 }.size
    }
}

fun main() {
    val solution = Solution()
    val result1 = solution.solution(
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0)
        )
    )
    println(result1)
    println("__)_)_)_)_)_)_)_)_")
    val result2 = solution.solution(
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 1, 0),
            intArrayOf(0, 0, 0, 0, 0)
        )
    )
    println(result2)
    println("__)_)_)_)_)_)_)_)_")
    val result3 = solution.solution(
        arrayOf(
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1, 1)
        )
    )
    println(result3)
    println("__)_)_)_)_)_)_)_)_")
}