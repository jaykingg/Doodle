package e_aloha.week7

import java.util.*

/**
 * https://www.acmicpc.net/problem/1697
 * 숨바꼭질
 *
 *
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val queue = LinkedList<Pair<Int, Int>>()
    val visited = IntArray(100001) { -1 }

    if (n == m) {
        println(0)
        println(1)
        return
    }

    queue.add(Pair(n, 0))
    visited[n] = 0

    var minTime = Int.MAX_VALUE
    var count = 0

    val di = arrayOf(-1, 1, 2)

    while (queue.isNotEmpty()) {
        val (currentN, currentSeconds) = queue.poll()

        if (m == currentN) {
            if (currentSeconds < minTime) {
                minTime = currentSeconds
                count = 1
            } else if (currentSeconds == minTime) {
                count++
            }
        }

        for (i in di.indices) {
            val nextN = if (i < 2) currentN + di[i] else currentN * di[i]
            val nextSeconds = currentSeconds + 1
            if (nextN in 0..100000) {
                if (visited[nextN] == -1 || visited[nextN] == nextSeconds) {
                    visited[nextN] = nextSeconds
                    queue.add(Pair(nextN, nextSeconds))
                }
            }
        }
    }

    println(minTime)
    println(count)
}
