class Solve15 {
    val map = Array(19){ IntArray(19){0}}
    fun main() {
        // 입력
        for(i in 0 until 19) {
            val line = readln().split(" ")
            for(j in 0 until 19) {
                map[i][j] = line[j].toInt()
            }
        }


        // 순회하면서 탐색
        for(i in map.indices) {
            for(j in map[0].indices) {
                if(map[i][j] == 1 || map[i][j] == 2) {
                    if(check(Pair(i,j), map[i][j])) {
                        return
                    }
                }
            }
        }

        println(0)
    }

    // 0,0 부터 순회하기때문에 0,0 쪽으로 탐색할 필요는 없음
    // 오른쪽, 아래, 대각선1(오른쪽하단), 대각선2(오른쪽상단)
    val direction = arrayOf(Pair(0,1), Pair(1,0), Pair(1,1), Pair(-1,1))
    val beforeDirection = arrayOf(Pair(0,-1), Pair(-1,0), Pair(-1,-1), Pair(1,-1))
    fun check(ball: Pair<Int,Int>, color: Int) : Boolean {
        val (y,x) = ball
        for(i in direction.indices) {
            var dy = y + direction[i].first
            var dx = x + direction[i].second
            var count = 1
            while(true) {
                if(dy < 0 || dy > 18 || dx < 0 || dx > 18) break
                if(map[dy][dx] != color) break
                count+=1
                dy += direction[i].first
                dx += direction[i].second
            }
            if(count == 5) {
                val bdy = y + beforeDirection[i].first
                val bdx = x + beforeDirection[i].second
                if(bdy > -1 && bdy < 19 && bdx > -1 && bdx < 19) {
                    if(map[bdy][bdx] == color) {
                        continue
                    }
                    else {
                        println(color)
                        println("${y+1} ${x+1}")
                        return true
                    }
                }
                else {
                    println(color)
                    println("${y+1} ${x+1}")
                    return true
                }
            }
        }
        return false
    }
}