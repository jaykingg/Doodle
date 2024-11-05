package e_aloha.week6

import java.util.*

/**
 * https://www.acmicpc.net/problem/16928
 * 뱀과 사다리 게임
 *
 * BFS
 * 1부터 시작하므로 1을 넣고 주사위 1~6 을 던질 경우를 고려, 조건필터를 거처 Queue 에 넣음
 * 1~6 까지 계산할때 뱀,사다리에 포함되는지 여부를 판단하는 조건이 추가 됨
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (ladder, snake) = readLine().split(" ").map { it.toInt() }
    val ladderAndSnake = mutableMapOf<Int, Int>()
    val visited = BooleanArray(101) { false }
    val queue = LinkedList<Pair<Int, Int>>()
    var result = Integer.MAX_VALUE

    repeat(ladder + snake) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        ladderAndSnake[x] = y
    }
 
    queue.add(1 to 0)
    visited[1] = true
    while (queue.isNotEmpty()) {
        val (location, count) = queue.poll()
        if (location == 100) result = minOf(result, count)
        for (dice in 1..6) {
            val next = location + dice
            if (next in 1..100 && !visited[next]) {
                if (ladderAndSnake.containsKey(next)) {
                    val nextValue = ladderAndSnake[next]!!.toInt()
                    if (!visited[nextValue]) {
                        visited[nextValue] = true
                        queue.add(nextValue to count + 1)
                    }
                } else {
                    visited[next] = true
                    queue.add(next to count + 1)
                }
            }
        }
    }

    println(result)


}
