package boj
// 괄호

import java.util.*

fun main() {
    val T = readLine()!!.toInt()

    repeat(T) {
        val input = readLine()!!
        val stack = Stack<Char>()

        try {
            input.forEach { if(it == '(') stack.push('(') else stack.pop() }
            println(if(stack.isEmpty()) "YES" else "NO")
        } catch (e: EmptyStackException) {
            println("NO")
        }
    }
}