package e_aloha.week6

/**
 * https://www.acmicpc.net/problem/14500
 * 테트로미노
 *
 * 반례도 다 맞는데 왜 틀렸는지 난 모르겠다
 *
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    // 각 모양 및 회전, 대칭 모양 정의
    val blocks = listOf(
        listOf(0 to 0, 0 to 1, 0 to 2, 0 to 3), // 일자형/회전
        listOf(0 to 0, 1 to 0, 2 to 0, 3 to 0),

        listOf(0 to 0, 0 to 1, 1 to 0, 1 to 1), // 정사각형

        listOf(0 to 0, 1 to 0, 2 to 0, 2 to 1), // L자형/회전
        listOf(0 to 1, 1 to 1, 2 to 1, 2 to 0),
        listOf(0 to 0, 0 to 1, 0 to 2, 1 to 2),
        listOf(1 to 0, 1 to 1, 1 to 2, 0 to 2),

        listOf(0 to 0, 1 to 0, 1 to 1, 1 to 2), // Z자형/회전
        listOf(1 to 0, 0 to 1, 0 to 2, 1 to 2),
        listOf(0 to 0, 0 to 1, 1 to 1, 1 to 2),
        listOf(1 to 0, 1 to 1, 0 to 1, 0 to 2),

        listOf(0 to 0, 1 to 0, 1 to 1, 2 to 1), // T자형/회전
        listOf(1 to 0, 0 to 1, 1 to 1, 2 to 1),
        listOf(0 to 0, 0 to 1, 0 to 2, 1 to 1),
        listOf(1 to 0, 1 to 1, 1 to 2, 0 to 1),

        listOf(0 to 0, 1 to 0, 1 to 1, 2 to 0), // L자형 대칭
        listOf(0 to 1, 1 to 1, 1 to 0, 2 to 1),
        listOf(0 to 0, 0 to 1, 0 to 2, 1 to 0),
        listOf(1 to 0, 0 to 1, 0 to 2, 1 to 2)
    )

    var max = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            for (shape in blocks) {
                var sum = 0
                var isValid = true
                for ((row, col) in shape) {
                    val nextRow = i + row
                    val nextCol = j + col
                    if (nextRow in 0 until n && nextCol in 0 until m) {
                        sum += board[nextRow][nextCol]
                    } else {
                        isValid = false
                        break
                    }
                }
                if (isValid) max = maxOf(max, sum)
            }
        }
    }

    println(max)
}
