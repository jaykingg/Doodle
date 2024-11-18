package e_aloha.week7

/**
 * https://www.acmicpc.net/problem/11054
 * 가장 긴 바이토닉 부분 수열
 *
 * DP
 */
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }

    val increasing = IntArray(n) { 1 }
    val decreasing = IntArray(n) { 1 }
 
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j]) {
                increasing[i] = maxOf(increasing[i], increasing[j] + 1)
            }
        }
    }

    for (i in n - 2 downTo 0) {
        for (j in n - 1 downTo i + 1) {
            if (arr[i] > arr[j]) {
                decreasing[i] = maxOf(decreasing[i], decreasing[j] + 1)
            }
        }
    }

    var maxLength = 0
    for (i in 0 until n) {
        maxLength = maxOf(maxLength, increasing[i] + decreasing[i] - 1)
    }

    println(maxLength)

}
