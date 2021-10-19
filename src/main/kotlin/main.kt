import java.util.*

fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val queue: Queue<Int> = LinkedList()
    val result = mutableListOf<Int>()

    for(i in 1..N) queue.add(i)

    while(queue.isNotEmpty()) {
        for(i in 1 until K){
            queue.offer(queue.poll())
        }
        result.add(queue.poll())
    }
    println("<".plus(result.joinToString(", ")).plus(">"))
}