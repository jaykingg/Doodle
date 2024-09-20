package e_aloha.week3

import java.util.*

/**
 * 3rd
 * https://www.acmicpc.net/problem/1966
 */
fun main() = with(System.`in`.bufferedReader()) {
    val testCase = readLine().toInt()

    repeat(testCase) {
        val (numberOfBooks: Int, position: Int) = readLine().split(" ").map { it.toInt() }
        val sequence = readLine().split(" ").map { it.toInt() }.toList()
        println(getSequence(position, sequence))
    }
}

fun getSequence(position: Int, sequence: List<Int>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var result = 0

    for (i in sequence.indices) {
        queue.add(Pair(i, sequence[i]))
    }

    while (sequence.isNotEmpty()) {
        val (index, priority) = queue.poll()
        if (queue.any { it.second > priority }) {
            queue.add(Pair(index, priority))
        } else {
            result++
            if (index == position) {
                break
            }
        }
    }

    return result
}

