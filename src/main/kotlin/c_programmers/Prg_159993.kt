package c_programmers

import java.util.*
import kotlin.collections.HashSet

class Prg_159993 {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/159993
    미로탈출
     */
    fun main() {
        val case1 = arrayOf("SOOOL","XXXXO","OOOOO","OXXXX","OOOOE") // 16
        val case2 = arrayOf("LOOXS","OOOOX","OOOOO","OOOOO","EOOOO") // -1, 탈출불가
        val result1 = solution(case1)
        val result2= solution(case2)

        if(result1 == 16) println("Result1 is true") else println(result1)
        if(result2 == -1) println("Result2 is true") else println(result2)
    }

    fun solution(maps: Array<String>): Int {
        val letters = findLetter(maps)
        val resultFromStoL = bfs(maps, letters.first, letters.second)
        val resultFromLtoE = bfs(maps, letters.second, letters.third)
        return if(resultFromStoL == -1 || resultFromLtoE == -1) -1 else resultFromStoL + resultFromLtoE
    }
    private fun findLetter(maps: Array<String>) : Triple<Pair<Int, Int>, Pair<Int, Int>, Pair<Int, Int>> {
        var letterS = Pair(0,0)
        var letterL = Pair(0,0)
        var letterE = Pair(0,0)

        for(i in maps.indices) {
            for(j in maps[0].indices) {
                when(maps[i][j]) {
                    'S' -> letterS = Pair(i,j)
                    'L' -> letterL = Pair(i,j)
                    'E' -> letterE = Pair(i,j)
                }
            }
        }
        return Triple(letterS, letterL, letterE)
    }

    private fun bfs(maps: Array<String>, startPoint: Pair<Int,Int>, endPoint: Pair<Int,Int>) : Int {
        val diff = arrayOf(Pair(0,1),Pair(0,-1),Pair(1,0),Pair(-1,0))
        val queue: Queue<Triple<Int,Int,Int>> = LinkedList()
        val visited = HashSet<Pair<Int,Int>>()

        queue.add(Triple(startPoint.first,startPoint.second,0))

        while(!queue.isEmpty()) {
            var (row, col, time) = queue.poll()
            val point = Pair(row,col)
            if(point in visited) {
                continue
            }
            visited.add(point)
            if(point == endPoint) {
                return time
            }
            time++

            for((dRow, dCol) in diff) {
                val nextRow = point.first + dRow
                val nextCol = point.second + dCol
                if(nextRow >= 0 && nextCol >= 0 && nextRow < maps.size && nextCol < maps[0].length) {
                    if(maps[nextRow][nextCol] != 'X') {
                        queue.add(Triple(nextRow,nextCol,time))
                    }
                }

            }
        }
        return -1
    }
}
