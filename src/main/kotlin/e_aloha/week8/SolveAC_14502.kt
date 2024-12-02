package e_aloha.week8

import java.util.*

/**
 * https://www.acmicpc.net/problem/14502
 * 연구소
 *
 *
 */

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    // 빈 공간과 바이러스 위치 탐색
    val emptySpaces = mutableListOf<Pair<Int, Int>>()
    val virusList = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until m) {
            when (map[i][j]) {
                0 -> emptySpaces.add(Pair(i, j))
                2 -> virusList.add(Pair(i, j))
            }
        }
    }

    val directions = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

    // 벽을 세운 후 바이러스 확산 시뮬레이션
    fun simulate(map: Array<IntArray>, walls: List<Pair<Int, Int>>): Int {
        // 맵 복사
        val tempMap = Array(n) { map[it].copyOf() }
        // 벽 세우기
        for ((x, y) in walls) {
            tempMap[x][y] = 1
        }

        // BFS로 바이러스 확산
        val queue: Queue<Pair<Int, Int>> = LinkedList(virusList)
        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            for ((dx, dy) in directions) {
                val nx = x + dx
                val ny = y + dy
                if (nx in 0 until n && ny in 0 until m && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2
                    queue.add(Pair(nx, ny))
                }
            }
        }

        // 안전 영역 계산
        return tempMap.sumOf { row -> row.count { it == 0 } }
    }

    // 조합 생성 함수
    fun getCombinations(list: List<Pair<Int, Int>>, k: Int): List<List<Pair<Int, Int>>> {
        val result = mutableListOf<List<Pair<Int, Int>>>()
        val combination = IntArray(k)
        fun dfs(depth: Int, start: Int) {
            if (depth == k) {
                result.add(combination.map { list[it] })
                return
            }
            for (i in start until list.size) {
                combination[depth] = i
                dfs(depth + 1, i + 1)
            }
        }
        dfs(0, 0)
        return result
    }

    // 가능한 벽 조합 탐색
    val wallCombinations = getCombinations(emptySpaces, 3)
    var maxSafeArea = 0

    for (walls in wallCombinations) {
        val safeArea = simulate(map, walls)
        maxSafeArea = maxOf(maxSafeArea, safeArea)
    }

    println(maxSafeArea)
}
