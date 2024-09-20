package e_aloha.week3

import java.util.*

/**
 * 2nd
 * https://www.acmicpc.net/problem/2606
 */
fun main() = with(System.`in`.bufferedReader()) {
    val computer = readLine().toInt()
    val times = readLine().toInt()
    val queue: Queue<Int> = LinkedList()
    val visited = BooleanArray(computer + 1) { false }
    /* 간선 맵 row,col == col,row == row 와 col 이 이어져 있음 */
    val edges = Array(computer + 1) { BooleanArray(computer + 1) { false } }
    /* 본인은 포함 시키지 않음  */
    var infectedComputers = 0

    repeat(times) {
        val (row, col) = readLine().split(" ").map { it.toInt() }
        edges[row][col] = true
        edges[col][row] = true
    }

    /* 시작점, 본인 제외 */
    queue.add(1)
    visited[1] = true

    while (queue.isNotEmpty()) {
        val row = queue.poll()
        for (i in 1 until visited.size) {
            if (!visited[i] && edges[row][i]) {
                infectedComputers++
                visited[i] = true
                queue.add(i)
            }
        }
    }

    println(infectedComputers)
}

