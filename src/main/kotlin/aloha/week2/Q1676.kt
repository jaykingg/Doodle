package aloha

/**
 * https://www.acmicpc.net/problem/1676
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n: Int = readLine()!!.toInt()
    if (n < 0 || n > 500) return
    println(n / 5 + n / 25 + n / 125)
}