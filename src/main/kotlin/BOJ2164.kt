import java.io.*
import java.util.*

// 카드2

fun solution1() {
    val N = readLine()!!.toInt()
    val queue: LinkedList<Int> = LinkedList()

    queue.addAll(1..N)

    while(queue.size > 2) {
        queue.pop()
        queue.offer(queue.pop())
    }

    println(queue.last)
}

fun solution2() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val queue: LinkedList<Int> = LinkedList()

    queue.addAll(1..N)

    while(queue.size > 2) {
        queue.poll()
        queue.offer(queue.poll())
    }

    bw.write("${queue.last}\n")

    bw.flush()
    br.close()
    bw.close()
}

fun main() {
    solution1()
    solution2()
}