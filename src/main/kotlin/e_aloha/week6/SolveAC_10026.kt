package e_aloha.week6

import java.util.*

/**
 * https://www.acmicpc.net/problem/10026
 * 적록색약
 *
 * BFS, 케이스를 둘로 나눠 계산한다
 * 케이스를 나눠도 2(100*100*4) 이므로 시간초과 발생 안함
 *
 * 처음엔 단순하고 R,G,B 의 영역을 구한다
 * 두번째엔 적 == 록 이므로 R 을 G 로 치환하여 재계산한다
 */
fun main() = with(System.`in`.bufferedReader()) {
    val time = readLine().toInt()
    val area = Array(time) { readLine()!!.toCharArray() }
    var visited = Array(time) { BooleanArray(time) { false } }
    val queue = LinkedList<Pair<Int, Int>>()
    val result = IntArray(2) { 0 }
    val di = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

    var sight = 0
    for (i in area.indices) {
        for (j in area[0].indices) {
            if (!visited[i][j]) {
                val flag = area[i][j]
                sight += 1
                queue.add(Pair(i, j))
                visited[i][j] = true
                while (queue.isNotEmpty()) {
                    val (row, col) = queue.poll()
                    for (k in di.indices) {
                        val nextRow = row + di[k].first
                        val nextCol = col + di[k].second
                        if (nextRow in 0 until time && nextCol in 0 until time) {
                            if (!visited[nextRow][nextCol] && area[nextRow][nextCol] == flag) {
                                visited[nextRow][nextCol] = true
                                queue.add(Pair(nextRow, nextCol))
                            }
                        }
                    }
                }
            }
        }
    }

    area.forEach { row ->
        row.forEachIndexed { colIndex, char ->
            if (char == 'R') {
                row[colIndex] = 'G'
            }
        }
    }

    // 초기화, 적 == 록 이므로 하나의 색으로 치환하여 다시 계산

    result[0] = sight
    visited = Array(time) { BooleanArray(time) { false } }
    sight = 0

    for (i in area.indices) {
        for (j in area[0].indices) {
            if (!visited[i][j]) {
                val flag = area[i][j]
                sight += 1
                queue.add(Pair(i, j))
                visited[i][j] = true
                while (queue.isNotEmpty()) {
                    val (row, col) = queue.poll()
                    for (k in di.indices) {
                        val nextRow = row + di[k].first
                        val nextCol = col + di[k].second
                        if (nextRow in 0 until time && nextCol in 0 until time) {
                            if (!visited[nextRow][nextCol] && area[nextRow][nextCol] == flag) {
                                visited[nextRow][nextCol] = true
                                queue.add(Pair(nextRow, nextCol))
                            }
                        }
                    }
                }
            }
        }
    }

    result[1] = sight

    println(result.joinToString(" "))

}
