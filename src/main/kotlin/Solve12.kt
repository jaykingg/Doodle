import java.util.*
class Solve12 {

    var visited = emptyArray<BooleanArray>()
    val countList: MutableList<Int> = mutableListOf()
    val diff = arrayOf(Pair(1,0),Pair(-1,0),Pair(0,1),Pair(0,-1))
    fun main() {
        val n = readln().toInt()
        val map = Array(n) {
            readln().toCharArray()
        }
        visited = Array(n) { BooleanArray(n) {false}}
        val q: Queue<Pair<Int,Int>> = LinkedList()

        for(i in 0 until n) {
            for(j in 0 until n) {
                if(map[i][j] == '1' && !visited[i][j]) {
                    var count = 1
                    visited[i][j] = true
                    q.add(Pair(i,j))
                    while(q.isNotEmpty()) {
                        val (dy,dx) = q.poll()
                        for(k in diff.indices) {
                            val ndy = dy +diff[k].first
                            val ndx = dx +diff[k].second
                            if(ndy in 0 until n && ndx in 0 until n) {
                                if(map[ndy][ndx] == '1' && !visited[ndy][ndx]) {
                                    count++
                                    visited[ndy][ndx] = true
                                    q.add(Pair(ndy,ndx))
                                }
                            }
                        }
                    }
                    countList.add(count)
                }
            }
        }
        countList.sort()
        println(countList.size)
        countList.forEach {
            println(it)
        }

    }
}