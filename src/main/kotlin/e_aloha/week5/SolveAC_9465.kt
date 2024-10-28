package e_aloha.week5

/**
 * https://www.acmicpc.net/problem/9465
 * 스티커
 *
 *
 * DP 문제이다.. 너무 싫다..
 * DFS 로 하면 시간초과 발생
 */
fun main() = with(System.`in`.bufferedReader()) {
    val case = readLine().toInt()

    repeat(case) {
        val n = readLine().toInt()
        val sticker = Array(2) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        val dp = Array(2) { IntArray(n) }


        if (n == 1) {
            println(maxOf(sticker[0][0], sticker[1][0]))
            return@repeat
        }

        dp[0][0] = sticker[0][0]
        dp[1][0] = sticker[1][0]
        dp[0][1] = sticker[1][0] + sticker[0][1]
        dp[1][1] = sticker[0][0] + sticker[1][1]

        for (i in 2 until n) {
            dp[0][i] = maxOf(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i]
            dp[1][i] = maxOf(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i]
        }

        println(maxOf(dp[0][n - 1], dp[1][n - 1]))
    }
}
