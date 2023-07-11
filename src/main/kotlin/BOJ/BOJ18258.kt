// 큐2

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val queue: Deque<Int> = LinkedList<Int>()

    val N: Int = br.readLine().toInt()

    repeat(N) {
        val cmd = br.readLine()

        when {
            cmd.contains("push")  -> queue.offer(cmd.split(" ")[1].toInt())
            cmd == "pop"   -> bw.write("${if(queue.isEmpty()) -1 else queue.poll()}\n")
            cmd == "size"  -> bw.write("${queue.size}\n")
            cmd == "empty" -> bw.write("${if(queue.isEmpty()) 1 else 0}\n")
            cmd == "front" -> bw.write("${if(queue.isEmpty()) -1 else queue.peek()}\n")
            cmd == "back"  -> bw.write("${if(queue.isEmpty()) -1 else queue.peekLast()}\n")
        }
    }

    bw.flush()
    br.close()
    bw.close()
}