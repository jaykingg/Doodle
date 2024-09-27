package e_aloha.week3

/**
 * 10th https://www.acmicpc.net/problem/14501
 *
 *
 * 2초이고 n 의 값이 15가 마지막이기 떄문에 시간적 여유가 있음
 */
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val timeArray = IntArray(n) { 0 }
    val priceArray = IntArray(n) { 0 }

    for (i in 0 until n) {
        val (time, price) = readLine().split(" ").map { it.toInt() }
        timeArray[i] = time
        priceArray[i] = price
    }

    val left = 0
    val end = 0
}
