import java.util.*

fun main() {
    val N: Int
    val K: Int

    val input = readLine()
    val queue: Queue<Int> = LinkedList()

    N = input!!.split(" ")[0].toInt()
    K = input.split(" ")[1].toInt()

    for(i in 1..N) queue.add(i)

    print("<")
    while(queue.isNotEmpty()) {
        for(i in 1 until K){
            queue.offer(queue.poll())
        }
        print("${queue.poll()}")
        if(queue.size != 0) print(", ")
    }
    print(">")
}