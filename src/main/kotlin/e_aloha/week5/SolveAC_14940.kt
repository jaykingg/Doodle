package e_aloha.week5

import java.util.*

/**
 * https://www.acmicpc.net/problem/14940
 * 쉬운 최단 거리
 *
 *
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val distances = Array(n) { IntArray(m) { -1 } }
    val di = arrayOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))

    var startRow = -1
    var startCol = -1

    // 목표 지점 찾기
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 2) {
                startRow = i
                startCol = j
                distances[i][j] = 0
                break
            }
        }
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(startRow, startCol))

    while (queue.isNotEmpty()) {
        val (row, col) = queue.poll()

        for (i in di) {
            val nextRow = row + i.first
            val nextCol = col + i.second

            if (nextRow in 0 until n && nextCol in 0 until m) {
                if (map[nextRow][nextCol] == 1 && distances[nextRow][nextCol] == -1) {
                    distances[nextRow][nextCol] = distances[row][col] + 1
                    queue.add(Pair(nextRow, nextCol))
                }
            }
        }
    }

    /**
     * 각 지점에서 목표지점까지의 거리를 출력한다.
     * 원래 갈 수 없는 땅인 위치는 0을 출력하고,
     * 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.
     */
    val result = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0) {
                result.append("0 ")  // 갈 수 없는 땅은 0으로 출력
            } else {
                result.append("${distances[i][j]} ")
            }
        }
        result.append("\n")
    }
    print(result)
}
