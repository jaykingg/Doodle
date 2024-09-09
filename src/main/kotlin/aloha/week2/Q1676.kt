package aloha

/**
 * https://www.acmicpc.net/problem/1676
 */

fun main() = with(System.`in`.bufferedReader()) {
    /**
     * 뒤가 0이 되려면, 팩토리얼 중에 a * b 가 10인 것이 있어야함
     * 즉 2^n * 5^n 이 필요
     * 범위는 500 이하 이므로 5^3 까지만 구해주면 됨
     * 5가 있으면 2는 자연스레 포함되어 5 만 구하면 됨
     */
    val n: Int = readLine()!!.toInt()
    if (n < 0 || n > 500) return
    println(n / 5 + n / 25 + n / 125)

}