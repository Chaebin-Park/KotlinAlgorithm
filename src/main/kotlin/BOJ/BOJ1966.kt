import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = br.readLine().toInt()

    repeat(input) {
        var cnt = 0
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val docs = br.readLine().split(" ")

        val docQueue: Queue<Pair<Int, Int>> = LinkedList()

        for((idx, doc) in docs.withIndex()) {
            docQueue.offer(Pair(idx, doc.toInt()))
        }

        while(true) {
            val max = docQueue.maxOf { it.second }
            val tmp = docQueue.poll()

            if(tmp.second == max) {
                cnt++
                if(tmp.first == M) {
                    bw.write("$cnt\n")
                    break
                }
                else    continue
            }
            else {
                docQueue.offer(tmp)
            }
        }
    }

    bw.flush()
    bw.close()
    br.close()
}