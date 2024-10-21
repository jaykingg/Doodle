package e_aloha.week5

import java.util.*

/**
 * https://www.acmicpc.net/problem/1389
 * 케빈 베이컨의 6단계 원칙
 * 그래프 문제 ,
 *
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
        val distances = IntArray(n + 1) { -1 }  // 각 유저까지의 거리를 저장 (-1은 미방문을 의미)
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        distances[start] = 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            // 현재 유저와 연결된 모든 친구를 탐색
            for (friend in graph[current]) {
                if (distances[friend] == -1) {  // 미방문
                    distances[friend] = distances[current] + 1  // 거리 갱신
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
}
