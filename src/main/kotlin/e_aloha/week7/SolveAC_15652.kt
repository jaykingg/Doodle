package e_aloha.week7

/**
 * https://www.acmicpc.net/problem/15652
 * N 과 M (4)
 *
 * 백트래킹
 * 모든 경우의 수를 탐색, 조건을 만족하지 않는 케이스는 배제
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()

    fun findM(start: Int) {
        if (result.size == m) {
            println(result.joinToString(" "))
            return
        }

        // 비내림차 순
        for (i in start..n) {
            result.add(i)
            findM(i)
            // 마지막 원소 제거 후 다음 숫자 탐색(백트래킹)
            result.removeAt(result.size - 1)
        }
        /**
         * [1]
         * [1,1] 제거
         * [1,2]
         * [1,3]
         * [1,1,1]
         * [1,1,2]
         * ...
         * m 과 같을 때 까지
         */
    }

    findM(1)
}
