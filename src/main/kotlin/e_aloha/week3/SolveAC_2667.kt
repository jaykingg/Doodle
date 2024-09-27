package e_aloha.week3

import java.util.*

/**
 * 9th https://www.acmicpc.net/problem/2667
 *
 * N 의 값이 작기 떄문에 시간은 상관 없어 보임
 */
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val houseArray = Array(n) { readLine().map { it.digitToInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(n) { false } }
    val queue = LinkedList<Pair<Int, Int>>()
    val di = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
    val result = mutableListOf<Int>()

    for (row in 0 until n) {
        for (col in 0 until n) {
            if (houseArray[row][col] == 1 && !visited[row][col]) {
                var count = 0
                queue.add(Pair(row, col))
                visited[row][col] = true
                count += 1

                while (queue.isNotEmpty()) {
                    var (qRow, qCol) = queue.poll()
                    for (k in di.indices) {
                        val nextRow = qRow + di[k].first
                        val nextCol = qCol + di[k].second
                        if (nextRow > -1 && nextRow < n && nextCol > -1 && nextCol < n) {
                            if (houseArray[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                                queue.add(Pair(nextRow, nextCol))
                                visited[nextRow][nextCol] = true
                                count += 1
                            }
                        }

                    }
                }
                result.add(count)
            }
        }
    }
    println(result.size)
    result.sorted().forEach { println(it) }
}

