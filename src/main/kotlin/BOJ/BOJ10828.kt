// 스택

import java.util.*

fun main(){
    val stack = Stack<Int>()
    val N = readLine()!!.toInt()

    for(i in 0 until N){
        val cmd = readLine()!!.split(" ")

        when(cmd[0]) {
            "push" -> stack.push(cmd[1].toInt())
            "pop" -> println("${if(stack.empty()) -1 else stack.pop()}")
            "size" -> println(stack.size)
            "empty" -> println("${if(stack.empty()) 1 else 0}")
            "top" -> println("${if(stack.empty()) -1 else stack.peek()}")
        }
    }
}