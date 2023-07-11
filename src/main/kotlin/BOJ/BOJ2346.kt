import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val input = StringTokenizer(br.readLine())
    val balloon: ArrayList<Pair<Int, Int>> = ArrayList()

    repeat(N) {balloon.add(Pair(it+1, input.nextToken().toInt()))}

    var idx = 0
    while(balloon.isNotEmpty()) {
        var move = balloon[idx].second
        val size = balloon.size - 1
        bw.write("${balloon[idx].first} ")
        balloon.removeAt(idx)

        if(move > 0)    move--
        idx = try { (idx + move) % size }
            catch (e: ArithmeticException) { 0 }
        if(idx < 0) idx += size
    }

    bw.flush()
    bw.close()
    br.close()
}
