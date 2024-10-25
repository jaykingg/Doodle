package e_aloha.week5

import java.util.*

/**
 * https://www.acmicpc.net/problem/1697
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val queue = LinkedList<Pair<Int, Int>>()
    var result = Integer.MAX_VALUE
    val visited = BooleanArray(100001) { false }

    if(n == m) println(0) return

    queue.add(Pair(n, 1))
    visited[n] = true

    val di = arrayOf(-1, 1, 2)
    while (queue.isNotEmpty()) {
        val (currentN, currentSeconds) = queue.poll()
        if (m == currentN) Math.min(result, currentSeconds)

        for (i in di.indices) {
            var nextN = 0
            val nextSeconds = currentSeconds + 1
            if (i < 2) {
                nextN = currentN + di[i]
            } else {
                nextN = currentN * di[i]
            }
            if (nextN > -1 && nextN < 100001 && !visited[nextN]) {
                visited[nextN] = true
                queue.add(Pair(nextN, nextSeconds))
            }
        }
    }

    println(result)
}
