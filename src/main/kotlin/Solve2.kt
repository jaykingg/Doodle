import java.util.LinkedList
import java.util.Queue

class Solve2 {

    fun main() {
        val maps: Array<String> = arrayOf("X591X","X1X5X","X231X", "1XXX1")
        println(solution(maps))
    }


    val dx = intArrayOf(0,0,-1,1)
    val dy = intArrayOf(1,-1,0,0)
    var visited = emptyArray<BooleanArray>()
    fun solution(maps: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val x = maps[0].length
        val y = maps.size
        visited = Array(y) { BooleanArray(x) { false } }

        for(colIndex in 0 until y) {
            for(rowIndex in 0 until x) {
                if(!visited[colIndex][rowIndex] && maps[colIndex][rowIndex] != 'X') {
                    answer.plus(bfs(Position(colIndex,rowIndex), maps))
                }
            }
        }
        if(answer.isEmpty()) answer.plus(-1)
        return answer.sortedArray()

    }

    fun bfs(position: Position, maps: Array<String>) : Int {
        var result: Int = 0
        val queue: Queue<Position> = LinkedList<Position>()
        queue.add(position)
        visited[position.y][position.x] = true

        while(!queue.isEmpty()) {
            val pos = queue.poll()
            result += maps[pos.y][pos.x].toChar() - '0'

            for(idx in 0 until 4) {
                val colIdx = pos.y + dy[idx]
                val rowIdx = pos.x + dx[idx]
                if(colIdx > -1 && colIdx < maps.size && rowIdx > -1 && rowIdx < maps[0].length) {
                    if(!visited[colIdx][rowIdx] && maps[colIdx][rowIdx] != 'X') {
                        queue.add(Position(colIdx,rowIdx))
                        visited[colIdx][rowIdx] = true
                    }
                }
            }
        }
        return result
    }

    class Position(y: Int, x: Int) {
        val y: Int
        val x: Int

        init {
            this.y = y
            this.x = x
        }
    }

}