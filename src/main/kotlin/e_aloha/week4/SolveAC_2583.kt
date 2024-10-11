package e_aloha.week4

import java.util.*

/**
 * 영역 구하기
 * https://www.acmicpc.net/problem/2583
 *
 * 단순 완전 탐색 문제이다
 * 먼저 직사각형을 맵에 체크해고 탐색하여 구한다
 * 100*100*100(M,N) 해도 1억 안 됨
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (row, col, case) = readLine().split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()
    val area = Array(row) { IntArray(col) { 0 } }
    val visited = Array(row) { BooleanArray(col) { false } }
    val queue = LinkedList<Pair<Int, Int>>()

    /**
     * 0,2 / 4,4
     * x1,y1 / x2,y2
     * 점으로 계산하기 귀찮으니까
     * x1 <= col < x2
     * y1 <= row < y2
     */
    repeat(case) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        for (rowY in y1 until y2) {
            for (colX in x1 until x2) {
                area[rowY][colX] = 1
            }
        }

    }

    val di = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
    val rowSize = area.size
    val colSize = area[0].size
    for (rowY in area.indices) {
        for (colX in area[0].indices) {
            if (area[rowY][colX] == 0 && !visited[rowY][colX]) {
                var count = 0
                visited[rowY][colX] = true
                queue.add(Pair(rowY, colX))
                count += 1

                while (queue.isNotEmpty()) {
                    val (baseRow, baseCol) = queue.poll()
                    for (k in di.indices) {
                        val nextRow = baseRow + di[k].first
                        val nextCol = baseCol + di[k].second
                        if (nextRow > -1 && nextCol > -1 && nextRow < rowSize && nextCol < colSize) {
                            if (area[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                                visited[nextRow][nextCol] = true
                                queue.add(Pair(nextRow, nextCol))
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
    println(result.sorted().joinToString(" "))
}

/*

5 7 3
0 2 4 4
1 1 2 5
4 0 6 2


 */
