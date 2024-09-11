package c_programmers

import java.util.*


class Prg_150365 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/150365
     * 미로 탈출 명령어
     */

    fun main() {
        println(solution(3,4,2,3,3,1,5) == "dllrl")
        println(solution(2,2,1,1,2,2,2) == "dr")
        println(solution(3,3,1,2,3,3,4) == "impossible")
    }

    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        val diff = arrayOf(Pair(1,0), Pair(0,-1), Pair(0,1), Pair(-1,0))
        val visited = mutableMapOf<Pair<Int,Int>,Int>()
        val queue:Queue<Triple<Pair<Int,Int>, Int, String>> = LinkedList()

        queue.add(Triple(Pair(x-1,y-1),0,""))

        while(queue.isNotEmpty()) {
            val (spot,move,d) = queue.poll()
            if(move == k && spot.first == r-1 && spot.second == c-1) {
                return d
            }
            if(move == k) continue
            for(i in diff.indices) {
                val ny = spot.first + diff[i].first
                val nx = spot.second + diff[i].second
                if(ny > -1 && ny < n && nx > -1 && nx < m) {
                    if(move < 5) {
                        var appendD = ""
                        when(i) {
                            0 -> appendD = "d"
                            1 -> appendD = "l"
                            2 -> appendD = "r"
                            3 -> appendD = "u"
                        }
                        queue.add(Triple(Pair(ny,nx), move+1, d+appendD))
                    }
                }
            }
        }

        return "impossible"
    }
}
