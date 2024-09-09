package aloha

/**
 * https://www.acmicpc.net/problem/2839
 */

fun main() = with(System.`in`.bufferedReader()) {
    /**
     * 3,5 중에
     * 큰 수로 나눠 떨어지는지 확인, 딱 나눠 떨어질 때 까지 작은 수를 뺴면서 검사함
     */
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