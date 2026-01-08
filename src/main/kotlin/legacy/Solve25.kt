package legacy

import java.util.LinkedList
import java.util.Queue

class Solve25 {
    fun main() {
        println(
            solution(
                6, 17,
                arrayOf(
                    intArrayOf(5, 4, 6),
                    intArrayOf(5, 2, 5),
                    intArrayOf(0, 4, 2),
                    intArrayOf(2, 3, 3),
                    intArrayOf(1, 2, 7),
                    intArrayOf(0, 1, 3)
                )
            ).joinToString(" ")
        )

        println(
            solution(
                4, 10,
                arrayOf(
                    intArrayOf(0, 1, 2),
                    intArrayOf(0, 2, 3)
                )
            ).joinToString(" ")
        )
    }

    fun solution(n: Int, k: Int, roads: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        val matrix: Array<IntArray> = Array(n) { IntArray(n) }

        for (i in roads.indices) {
            val (row, col, v) = roads[i]
            matrix[row][col] = v
            matrix[col][row] = v
        }

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val result: MutableSet<Int> = mutableSetOf()
        queue.add(Pair(0, 0))

        while (queue.isNotEmpty()) {
            val (nowV, sum) = queue.poll()
            for (j in 0 until n) {
                if (matrix[nowV][j] <= 0) continue
                if (sum + matrix[nowV][j] == k) {
                    result.add(j)
                } else if (sum + matrix[nowV][j] < k) {
                    queue.add(Pair(j, sum + matrix[nowV][j]))
                }
            }
        }
        answer = result.sorted().toIntArray()
        return if (answer.isNotEmpty()) {
            answer
        } else {
            intArrayOf(-1)
        }

    }

}
