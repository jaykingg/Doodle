package e_aloha.week3

import java.util.Stack

/**
 * 1st
 * https://www.acmicpc.net/problem/10773
 */
fun main() = with(System.`in`.bufferedReader()) {
    val stack: Stack<Int> = Stack()
    val k = readLine().toInt()

    repeat(k) {
        val number = readLine().toInt()
        if(number == 0 && stack.isNotEmpty()) {
            stack.pop()
        }
        else {
            stack.push(number)
        }
    }
    println(stack.sum())
}