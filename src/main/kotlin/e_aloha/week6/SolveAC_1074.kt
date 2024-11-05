package e_aloha.week6

/**
 * https://www.acmicpc.net/problem/1074
 * Z
 *
 *
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (N, r, c) = readLine()!!.split(" ").map { it.toInt() }
    var size = 1 shl N  // 2^N 크기
    var row = r
    var col = c
    var number = 0

    while (size > 1) {
        size /= 2

        when {
            row < size && col < size -> {
                // 1사분면: order 변화 없음
            }

            size in (row + 1)..col -> {
                // 2사분면
                number += size * size
                col -= size
            }

            size in (col + 1)..row -> {
                // 3사분면
                number += 2 * size * size
                row -= size
            }

            row >= size && col >= size -> {
                // 4사분면
                number += 3 * size * size
                row -= size
                col -= size
            }
        }
    }

    println(number)
}
