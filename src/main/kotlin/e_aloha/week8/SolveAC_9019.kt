package e_aloha.week8

import java.util.*

/**
 * https://www.acmicpc.net/problem/9019
 * DSLR
 *
 *
 */

fun main() {
    val t = readLine()!!.toInt()
    val results = mutableListOf<String>()

    repeat(t) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        results.add(findShortestCommand(a, b))
    }

    results.forEach { println(it) }
}

// BFS
fun findShortestCommand(start: Int, target: Int): String {
    // 숫자 0~9999의 방문 여부
    val visited = BooleanArray(10000)
    val queue: Queue<Pair<Int, String>> = LinkedList()

    // 시작 숫자와 빈 명령어
    queue.add(Pair(start, ""))
    visited[start] = true

    while (queue.isNotEmpty()) {
        val (current, commands) = queue.poll()

        // 목표 숫자에 도달하면 명령어 반환
        if (current == target) {
            return commands
        }

        // 각 연산 수행
        val d = (current * 2) % 10000
        if (!visited[d]) {
            queue.add(Pair(d, commands + "D"))
            visited[d] = true
        }

        val s = if (current == 0) 9999 else current - 1
        if (!visited[s]) {
            queue.add(Pair(s, commands + "S"))
            visited[s] = true
        }

        val l = (current % 1000) * 10 + (current / 1000)
        if (!visited[l]) {
            queue.add(Pair(l, commands + "L"))
            visited[l] = true
        }

        val r = (current % 10) * 1000 + (current / 10)
        if (!visited[r]) {
            queue.add(Pair(r, commands + "R"))
            visited[r] = true
        }
    }

    return ""
}
