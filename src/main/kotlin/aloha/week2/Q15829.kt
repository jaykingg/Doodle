package aloha

/**
 * https://www.acmicpc.net/problem/15829
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val word = readLine()!!.toString()
    val r = 31
    val m = 1234567891

    var result = 0L
    var pow = 1L

    repeat(n) {
        result += (word[it] - 'a' + 1) * pow % m
        pow = (pow * r) % m
    }
    println(result % m)
}