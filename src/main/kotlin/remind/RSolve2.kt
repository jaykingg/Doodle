package remind

import java.util.*

class RSolve2 {
    companion object {
        fun main() {
            val maps: Array<String> = arrayOf("X591X", "X1X5X", "X231X", "1XXX1")
            println(solution(maps))
        }

        fun solution(maps: Array<String>): List<Int> {
            val days: MutableList<Int> = mutableListOf()
            val direction: Array<Pair<Int, Int>> = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))
            val visited: Array<BooleanArray> = Array(maps.size) { BooleanArray(maps[0].length) { false } }


            val queue: Queue<Pair<Int, Int>> = LinkedList()
            for (i in 0 until maps.size) {
                for (j in 0 until maps[0].length) {
                    if (maps[i][j] != 'X' && !visited[i][j]) {
                        var day: Int = maps[i][j] - '0'
                        queue.add(Pair(i, j))
                        visited[i][j] = true
                        while (queue.isNotEmpty()) {
                            val (row, col) = queue.poll()
                            for (di in direction) {
                                val nextRow = row + di.first
                                val nextCol = col + di.second
                                if (nextRow > -1 && nextRow < maps.size && nextCol > -1 && nextCol < maps[0].length) {
                                    if (maps[nextRow][nextCol] != 'X' && !visited[nextRow][nextCol]) {
                                        queue.add(Pair(nextRow, nextCol))
                                        visited[nextRow][nextCol] = true
                                        day += (maps[nextRow][nextCol] - '0')
                                    }
                                }
                            }
                        }
                        days.add(day)
                    }
                }
            }

            if (days.isEmpty()) {
                days.add(-1)
            }
            return days.sorted()
        }
    }
}