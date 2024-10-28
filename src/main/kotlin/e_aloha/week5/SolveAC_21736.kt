package e_aloha.week5

import java.util.*

/**
 * https://www.acmicpc.net/problem/21736
 * 헌내기는 친구가 필요해
 *
 *
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (row, col) = readLine().split(" ").map { it.toInt() }
    val campus = Array(row) { Array(col) { 'O' } }
    val visited = Array(row) { BooleanArray(col) { false } }
    val queue = LinkedList<Pair<Int, Int>>()

    for (i in campus.indices) {
        val line = readLine().toCharArray()
        for (j in campus[0].indices) {
            campus[i][j] = line[j]
            if (line[j] == 'I') {
                queue.add(Pair(i, j))
                visited[i][j] = true
            }
        }
    }

    val di = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
    var count = 0
    while (queue.isNotEmpty()) {
        val (qRow, qCol) = queue.poll()
        for (k in di.indices) {
            val nextRow = qRow + di[k].first
            val nextCol = qCol + di[k].second
            if (nextRow > -1 && nextRow < row && nextCol > -1 && nextCol < col) {
                if (!visited[nextRow][nextCol] && campus[nextRow][nextCol] != 'X') {
                    visited[nextRow][nextCol] = true
                    queue.add(Pair(nextRow, nextCol))
                    if (campus[nextRow][nextCol] == 'P') count++
                }
            }
        }
    }
    if (count == 0) println("TT") else println(count)
}
