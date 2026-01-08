package e_aloha.week9

import java.util.*

/**
 * https://www.acmicpc.net/problem/2206
 * 벽 부수고 이동하기
 */

data class WallState(val x: Int, val y: Int, val broken: Int)

fun main() {
    /**
     * 벽의 위치를 저장해놓는다.
     * 벽을 부수지 않을 때부터 벽위치 저장해놓은 것을 순서대로 부순 뒤 BFS를 실행하여 최소값을 구한다.
     *
     * ====> 는 시간 초과, 여러 번의 BFS 수행이 문제 이다? 횟수를 줄인다
     * => 3차원 배열을 사용하여 해당 부분이 벽을 부쉈는지 안 부쉈는지 확인다
     *
     *
     */
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(n) { readLine()!!.map { it - '0' }.toIntArray() }

    println(bfs(n, m, map))
}

fun bfs(n: Int, m: Int, map: Array<IntArray>): Int {
    val directions = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
    val queue: Queue<WallState> = LinkedList()

    // [N][M][State]
    val visited = Array(n) { Array(m) { BooleanArray(2) } }

    // 1,1 시작 고정, 안 부숨(0)
    queue.offer(WallState(0, 0, 0))
    visited[0][0][0] = true

    // 시작 칸 포함
    var distance = 1

    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val (x, y, broken) = queue.poll()

            // 도착 지점인 (N,M) 도달 시 최단 거리 반환
            if (x == n - 1 && y == m - 1) return distance

            for ((dx, dy) in directions) {
                val nx = x + dx
                val ny = y + dy

                if (nx in 0 until n && ny in 0 until m) {
                    // 벽이 아니고 방문한 적이 없다면 이동
                    if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                        queue.offer(WallState(nx, ny, broken))
                        visited[nx][ny][broken] = true
                    }

                    // 벽이지만 아직 부순 적이 없다면 부수고 이동 -> 부순 적이 있다면 추가 안함
                    if (map[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                        queue.offer(WallState(nx, ny, 1))
                        visited[nx][ny][1] = true
                    }
                }
            }
        }
        distance++
    }

    // 도착 불가
    return -1
}
