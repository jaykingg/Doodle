package c_programmers

import java.util.LinkedList
import java.util.Queue

class Prg_169199 {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/169199
    리코쳇 로봇
     */

    fun main() {
        if(solution(arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D....")) == 7) println("pass example1")
        if(solution(arrayOf(".D.R", "....", ".G..", "...D")) == -1) println("pass example2")
    }

    fun solution(board: Array<String>): Int {
        val positions = findPosition(board)
        val count = bfs(positions, board)
        return count
    }

    private fun findPosition(board: Array<String>) : Pair<Pair<Int, Int>, Pair<Int, Int>> {
        var start = Pair(0,0)
        var end = Pair(0,0)

        for(i in board.indices) {
            for(j in board[i].indices) {
                when(board[i][j]) {
                    'R' -> start = Pair(i,j)
                    'G' -> end = Pair(i,j)
                }
            }
        }
        return Pair(start, end)
    }

    private fun bfs(positions: Pair<Pair<Int, Int>, Pair<Int,Int>>, board: Array<String>) : Int {
        val diff = arrayOf(Pair(1,0),Pair(-1,0),Pair(0,1),Pair(0,-1))
        val queue: Queue<Triple<Int,Int,Int>> = LinkedList()
        val visited = HashSet<Pair<Int,Int>>()


        queue.add(Triple(positions.first.first,positions.first.second,0))

        while(!queue.isEmpty()) {
            val (row,col,count) = queue.poll()
            val point = Pair(row,col)
            if(point == positions.second) return count

            for((drow, dcol) in diff) {
                var nrow = point.first
                var ncol = point.second
                while(true) {
                    nrow += drow
                    ncol += + dcol
                    if(nrow < 0 || nrow >= board.size || ncol < 0 || ncol >= board[0].length || board[nrow][ncol] == 'D') break
                }
                nrow -= drow
                ncol -= dcol
                if(Pair(nrow,ncol) in visited) continue
                visited.add(Pair(nrow,ncol))
                queue.add(Triple(nrow,ncol,count+1))
            }
        }
        return -1
    }
}
