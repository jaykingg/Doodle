package e_aloha.week5

import java.util.*

/**
 * https://www.acmicpc.net/problem/1389
 * 케빈 베이컨의 6단계 원칙
 *
 *
 * 그래프 문제
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    fun bfs(start: Int): Int {
        val distances = IntArray(n + 1) { -1 }
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        distances[start] = 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            // 현재 유저와 연결된 모든 친구를 탐색
            for (friend in graph[current]) {
                if (distances[friend] == -1) {
                    distances[friend] = distances[current] + 1
                    queue.add(friend)
                }
            }
        }

        return distances.sumOf { if (it != -1) it else 0 }
    }

    var minValue = Int.MAX_VALUE
    var result = 0

    for (i in 1..n) {
        val bacon = bfs(i)
        if (bacon < minValue) {
            minValue = bacon
            result = i
        }
    }

    println(result)

//    val (n, m) = readLine().split(" ").map { it.toInt() }
//    val inf = 1000000
//    val map = Array(n + 1) { IntArray(n + 1) { inf } }
//
//    for (i in 1..n) {
//        map[i][i] = 0
//    }
//
//    repeat(m) {
//        val (a, b) = readLine().split(" ").map { it.toInt() }
//        map[a][b] = 1
//        map[b][a] = 1
//    }
//
//    for (k in 1..n) {
//        for (i in 1..n) {
//            for (j in 1..n) {
//                map[i][j] = minOf(map[i][j], map[i][k] + map[k][j])
//            }
//        }
//    }
//
//    var min = Int.MAX_VALUE
//    var resultValue = 0
//
//    for (i in 1..n) {
//        val bacon = map[i].slice(1..n).sum()
//        if (bacon < min) {
//            min = bacon
//            resultValue = i
//        }
//    }
//
//    println(resultValue)
}
