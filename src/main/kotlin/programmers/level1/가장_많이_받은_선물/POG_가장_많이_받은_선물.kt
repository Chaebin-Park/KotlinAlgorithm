package programmers.level1.가장_많이_받은_선물

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val nextMonth = friends.associateWith { 0 }.toMutableMap()

        val giftIndex = friends.associateWith { 0 }.toMutableMap()
        val friendsMatrix = friends.associateWith { friends.associateWith { 0 }.toMutableMap() }.toMutableMap()
        gifts.forEach { string ->
            val gift = string.split(" ")

            giftIndex[gift[0]] = giftIndex[gift[0]]!!.plus(1)
            giftIndex[gift[1]] = giftIndex[gift[1]]!!.minus(1)

            friendsMatrix[gift[0]]?.let {
                it[gift[1]] = it[gift[1]]!!.plus(1)
            }
        }

        friends.forEach { giver ->
            friends.forEach { receiver ->
                val first = friendsMatrix[giver]!![receiver] ?: 0
                val second = friendsMatrix[receiver]!![giver] ?: 0

                if (first > second) nextMonth[giver] = nextMonth[giver]!!.plus(1)
                else if (first == second) {
                    val firstIndex = giftIndex[giver] ?: 0
                    val secondIndex = giftIndex[receiver] ?: 0
                    if (firstIndex > secondIndex) nextMonth[giver] = nextMonth[giver]!!.plus(1)
                }
            }
        }

        val result = nextMonth.maxOf { it.value }
        println(result)
        return result
    }
}

fun main() {
    val solution = Solution()

    var friends = arrayOf("muzi", "ryan", "frodo", "neo")
    var gifts = arrayOf(
        "muzi frodo",
        "muzi frodo",
        "ryan muzi",
        "ryan muzi",
        "ryan muzi",
        "frodo muzi",
        "frodo ryan",
        "neo muzi"
    )
    solution.solution(friends, gifts) // result 2

    println("============================================================")

    friends = arrayOf("joy", "brad", "alessandro", "conan", "david")
    gifts = arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david")
    solution.solution(friends, gifts) // result 4

    println("============================================================")

    friends = arrayOf("a", "b", "c")
    gifts = arrayOf("a b", "b a", "c a", "a c", "a c", "c a")
    solution.solution(friends, gifts) // result 0
}