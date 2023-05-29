import java.lang.Integer.min
import java.util.*

/*
    https://www.acmicpc.net/problem/2564
    경비원
 */
class Solve16 {
    fun main() {
        val (row, col) = readln().split(" ").map{ it.toInt()}
        val map = Array(col+1) {IntArray(row+1){-1}}
        val visited = Array(col+1) {BooleanArray(row+1){false}}
        val storeSize = readln().toInt()
        var startY: Int = 0
        var startX: Int = 0

        for(i in map.indices) {
            for(j in map[0].indices) {
                if(i == 0) {
                    map[i][j] = 0
                }
                else if(i == map.size -1) {
                    map[i][j] = 0
                }
                else if(j == 0) {
                    map[i][j] = 0
                }
                else if(j == map[0].size-1) {
                    map[i][j] = 0
                }
            }
        }

        for(i in 0 until storeSize+1) {
            val (d,step) = readln().split(" ").map { it.toInt() }
            if(i != storeSize) {
                when(d) {
                    /*
                    1 -> 북
                    2 -> 남
                    3 -> 서
                    4 -> 동
                     */
                    1 -> map[0][step] = Integer.MAX_VALUE
                    2 -> map[map.size-1][step] = Integer.MAX_VALUE
                    3 -> map[step][0] = Integer.MAX_VALUE
                    4 -> map[step][map[0].size-1] = Integer.MAX_VALUE
                }
            }
            else {
                when(d) {
                    1 -> {
                        startY = 0
                        startX = step
                    }
                    2 -> {
                        startY = map.size-1
                        startX = step
                    }
                    3 -> {
                        startY = step
                        startX = 0
                    }
                    4 -> {
                        startY = step
                        startX = map[0].size-1
                    }
                }
            }
        }

        val q: Queue<Pair<Pair<Int,Int>,Int>> = LinkedList()
        q.add(Pair(Pair(startY,startX),0))

        val direction = arrayOf(Pair(0,-1),Pair(0,1),Pair(-1,0),Pair(1,0))

        while(q.isNotEmpty()) {
            val qp = q.poll()
            val (y,x) = qp.first
            var count = qp.second

            visited[y][x] = true

            for(i in direction.indices) {
                var dy = y + direction[i].first
                var dx = x + direction[i].second
                var dcount = count
                while(true) {
                    if(dy < 0 || dy > map.size-1 || dx < 0 || dx > map[0].size-1) {
                        break
                    }
                    if(map[dy][dx] == -1 || visited[dy][dx]) {
                        break
                    }
                    if((dy == 0 && dx == 0) || (dy == map.size-1 && dx == 0) || (dy == 0 && dx == map[0].size-1) || (dy == map.size-1 && dx == map[0].size-1)) {
                        q.add(Pair(Pair(dy,dx),dcount+1))
                        break
                    }
                    dcount++
                    visited[dy][dx] = true
                    if(map[dy][dx] > 0) {
                        map[dy][dx] = min(map[dy][dx], dcount)
                    }
                    dy += direction[i].first
                    dx += direction[i].second
                }
            }
        }
        var result = 0
        for(i in map.indices) {
            for(j in map[0].indices) {
                if(map[i][j] > 0) {
                    result += map[i][j]
                }
            }
        }
        println(result)
    }
}