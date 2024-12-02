package e_aloha.week8

/**
 * https://www.acmicpc.net/problem/1932
 * 정수 삼각형
 *
 *
 */
fun main() {
    val n = readLine()!!.toInt()
    val triangle = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    // DP 계산
    for (i in 1 until n) {
        for (j in triangle[i].indices) {
            // 왼쪽 위에서 내려오는 경우
            val fromLeft = if (j > 0) triangle[i - 1][j - 1] else 0
            // 바로 위에서 내려오는 경우
            val fromAbove = if (j < triangle[i - 1].size) triangle[i - 1][j] else 0
            // 현재 위치의 최대 합 계산
            triangle[i][j] += maxOf(fromLeft, fromAbove)
        }
    }
    println(triangle[n - 1].maxOrNull())
}
