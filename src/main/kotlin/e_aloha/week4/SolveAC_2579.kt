package e_aloha.week4

/**
 * 계단오르기
 * https://www.acmicpc.net/problem/2579
 *
 * Queue 로 풀었다가 바로 시간초과 떴다
 */
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val stepArray = IntArray(n) { readLine()!!.toInt() }

    if (n == 1) {
        println(stepArray[0])
        return
    }

    // dp[i]는 i번째 계단까지 올랐을 때의 최대 점수
    val dp = IntArray(n)

    dp[0] = stepArray[0]
    dp[1] = stepArray[0] + stepArray[1]
    // 1칸 점프한 것과 2칸 점프한 것의 max 를 넣어준다
    if (n > 2) dp[2] = maxOf(stepArray[1] + stepArray[2], stepArray[0] + stepArray[2])

    for (i in 3 until n) {
        dp[i] = maxOf(dp[i - 2], dp[i - 3] + stepArray[i - 1]) + stepArray[i]
    }

    println(dp[n - 1])
}
