package e_aloha.week4

/**
 * 동전 0
 * https://www.acmicpc.net/problem/11047
 *
 *  그리디 이다.
 *  큰 금액 부터 차감해서 K 를 완성시키면된다
 */
fun main() = with(System.`in`.bufferedReader()) {
    var (N, K) = readLine().split(" ").map { it.toInt() }
    val coinArray = IntArray(N) { 0 }
    var result = 0

    for (i in 0 until N) {
        coinArray[i] = readLine()!!.toInt()
    }

    for (i in N - 1 downTo 0) {
        if (coinArray[i] > K) continue
        result += (K / coinArray[i])
        K %= coinArray[i]
        if (K == 0) break
    }

    println(result)
}
