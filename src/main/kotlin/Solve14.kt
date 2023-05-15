import java.util.*

class Solve14 {
    fun main() {
        val fLine = readln().split(" ")
        val n = fLine[0].toInt()
        val w = fLine[1].toInt()
        val L = fLine[2].toInt()
        val bridge: Queue<Int> = LinkedList()
        var time = 0
        var currentW = 0

        val trucks = readln().split(" ").map { it.toInt() }

        for(i in trucks.indices) {
            while(true) {
                if(bridge.size == w) {
                    currentW -= bridge.poll()
                }
                if(L >= currentW + trucks[i]) break
                bridge.add(0)
                time++
            }
            bridge.add(trucks[i])
            currentW += trucks[i]
            time++
        }
        println(time+w)
    }
}