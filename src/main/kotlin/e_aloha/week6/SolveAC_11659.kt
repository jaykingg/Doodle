package e_aloha.week6

/**
 * https://www.acmicpc.net/problem/11659
 * 구간 합 구하기 4
 *
 * 누적 합 배열, 단순 합 문제인데 정답률이 낮을리가 없음 ㅎ
 * 구간 i,j 의 합은 (j 까지의 합) - (i-1 까지의 합) 으로 구할 수 있음
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }

    val sum = IntArray(n + 1)
    for (i in 1..n) {
        sum[i] = sum[i - 1] + arr[i - 1]
    }

    repeat(m) {
        val (i, j) = readLine().split(" ").map { it.toInt() }
        println(sum[j] - sum[i - 1])
    }
}

