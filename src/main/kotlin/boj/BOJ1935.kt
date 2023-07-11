package boj

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val stack = Stack<Double>()
    val prefix = br.readLine()
    val numArray = IntArray(n)
    repeat(n) {numArray[it] = br.readLine().toInt()}

    repeat(prefix.length) {
        val ch = prefix[it]
        if(ch in 'A'..'Z') {
            val num = numArray[ch - 'A']
            stack.push(num.toDouble())
        }
        else {
            val num1 = stack.pop()
            val num2 = stack.pop()

            when(ch) {
                '+' -> stack.push(num2 + num1)
                '-' -> stack.push(num2 - num1)
                '*' -> stack.push(num2 * num1)
                '/' -> stack.push(num2 / num1)
            }
        }
    }
    println(String.format("%.2f", stack.pop()))
}