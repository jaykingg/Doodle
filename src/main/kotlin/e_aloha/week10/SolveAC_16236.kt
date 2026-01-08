package e_aloha.week10

import java.util.*

/**
 * https://www.acmicpc.net/problem/16236
 * 아기 상어
 */

fun main() {
    /**
     *  가장 가까운 먹을 수 있는 물고기를 찾고, 조건에 맞게 먹고 이동하는 걸 반복
     *  먹을 때마다 "크기" 가 커진다.
     */

    val n = readln().toInt()
    val map = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val dx = intArrayOf(-1, 0, 0, 1)
    val dy = intArrayOf(0, -1, 1, 0)

    lateinit var shark: Shark

    // 샤크 베이비 ㅇㄷ?
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == 9) {
                shark = Shark(i, j)
                map[i][j] = 0
                break
            }
        }
    }

    var time = 0

    // 먹을 수 있을 때까지
    while (true) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val visited = Array(n) { BooleanArray(n) }
        val dist = Array(n) { IntArray(n) }

        queue.offer(Pair(shark.x, shark.y))
        visited[shark.x][shark.y] = true

        val fishes = mutableListOf<Fish>()


        // 탐색하면서 먹을 수 있는 물고기를 모두 저장
        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()

            for (dir in 0 until 4) {
                val nx = x + dx[dir]
                val ny = y + dy[dir]

                // 베이비의 크기보다 같거나 작으면 먹을 수 있음
                if (nx in 0 until n && ny in 0 until n && !visited[nx][ny] && map[nx][ny] <= shark.size) {
                    visited[nx][ny] = true
                    dist[nx][ny] = dist[x][y] + 1
                    queue.offer(Pair(nx, ny))

                    // 먹을 수 있는 물고기 저장
                    if (map[nx][ny] in 1 until shark.size) {
                        fishes.add(Fish(nx, ny, dist[nx][ny]))
                    }
                }
            }
        }

        // 먹을 수 있는 고기 없으면 끝
        if (fishes.isEmpty()) break

        // 조건에 맞게 정렬: 거리 → 위 → 왼
        fishes.sortWith(compareBy({ it.dist }, { it.x }, { it.y }))
        val target = fishes.first()

        // 이동 및 먹기
        shark.x = target.x
        shark.y = target.y
        shark.eat += 1
        time += target.dist
        map[target.x][target.y] = 0

        // 크기 증가
        if (shark.eat == shark.size) {
            shark.size += 1
            shark.eat = 0
        }
    }

    println(time)
}

data class Shark(var x: Int, var y: Int, var size: Int = 2, var eat: Int = 0)

data class Fish(val x: Int, val y: Int, val dist: Int)
