import java.io.*
import java.util.*

fun noStack(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val str = br.readLine()
    var openBracket = 0
    var result = 0

    repeat(str.length) {
        val ch = str[it]

        if(ch == '(') {
            openBracket++
        }
        else {
            openBracket--

            if(str[it-1] == '(')    result += openBracket
            else    result++
        }
    }

    bw.write("$result\n")
    bw.flush()
    bw.close()
    br.close()
}

fun useStack() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val str = br.readLine()
    val stack = Stack<Char>()
    var result = 0

    repeat(str.length) {
        val ch = str[it]

        if(ch == '(') {
            stack.push('(')
        }
        else {
            stack.pop()

            if(str[it-1] == '(')    result += stack.size
            else    result++
        }
    }

    bw.write("$result\n")
    bw.flush()
    bw.close()
    br.close()
}

fun main() {
    noStack()
    useStack()
}
