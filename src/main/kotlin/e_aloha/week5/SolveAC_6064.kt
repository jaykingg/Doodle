package e_aloha.week5

/**
 * https://www.acmicpc.net/problem/6064
 * 카잉 달력
 *
 *
 * O(M*N) 일 경우 시간초과
 *
 */
fun main() = with(System.`in`.bufferedReader()) {

    /**
     * y 를 신경쓰찌말고, x 를 맞추고 나서 y를 찾는다
     */
    val case = readLine().toInt()
    var results = -1

    repeat(case) {
        val (M, N, x, y) = readLine().split(" ").map { it.toInt() }
        var k = x
        var flag = false

        while (k <= M * N) {
            if ((k - 1) % N + 1 == y) {
                results = k
                flag = true
                break
            }
            k += M
        }

        if (!flag) {
            println(-1)
        } else {
            println(results)
        }

        results = -1
    }
}
