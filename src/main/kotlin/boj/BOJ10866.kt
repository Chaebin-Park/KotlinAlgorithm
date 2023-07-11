package boj

// 덱
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine()!!.toInt()
    val deque: Deque<Int> = LinkedList()

    repeat(N) {
        val cmd = br.readLine()
        when {
            cmd.contains("push") -> {
                if(cmd.contains("front"))   deque.addFirst(cmd.split(" ")[1].toInt())
                else    deque.addLast(cmd.split(" ")[1].toInt())
            }
            cmd.contains("pop") -> {
                if(cmd.contains("front"))   bw.write("${if(deque.isEmpty()) -1 else deque.pollFirst()}\n")
                else    bw.write("${if(deque.isEmpty()) -1 else deque.pollLast()}\n")
            }
            cmd == "size"   -> bw.write("${deque.size}\n")
            cmd == "empty"  -> bw.write("${if(deque.isEmpty()) 1 else 0}\n")
            cmd == "front"  -> bw.write("${if(deque.isEmpty()) -1 else deque.peekFirst()}\n")
            cmd == "back"   -> bw.write("${if(deque.isEmpty()) -1 else deque.peekLast()}\n")
        }
    }
    bw.flush()
    bw.close()
    br.close()
}