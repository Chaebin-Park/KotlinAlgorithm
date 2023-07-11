import java.io.*
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    var ptr = 1
    val stack = Stack<Int>()
    val sb = StringBuilder()

    for(i in 0 until n) {
        val num = br.readLine().toInt()
        while(ptr <= num) {
            stack.push(ptr)
            ptr+=1
            sb.append("+\n")
        }

        if(num == stack.peek()) {
            stack.pop()
            sb.append("-\n")
        } else {
            sb.clear()
            sb.append("NO\n")
            break
        }
    }

    print(sb)
    br.close()
}