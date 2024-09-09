package aloha

/**
 * https://www.acmicpc.net/problem/2839
 */

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    var count = 0

    while (true) {
        if (n % 5 == 0) {
            count += n / 5
            break
        }
        count++
        n -= 3

        if (n < 0) {
            count = -1
            break
        }
    }
    println(count)
}