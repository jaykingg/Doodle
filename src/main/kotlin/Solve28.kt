import java.util.LinkedList
import java.util.Queue

class Solve28 {
    fun main() {
        println(solution(intArrayOf(93, 30, 55), intArrayOf(1,30,5)).joinToString { "$it" })
        println(solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1,1,1,1,1,1)).joinToString { "$it" })
    }

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val progressesQ: Queue<Int> = LinkedList()
        val speedsQ: Queue<Int> = LinkedList()

        for(i in progresses.indices) {
            progressesQ.add(progresses[i])
            speedsQ.add(speeds[i])
        }

        val result: MutableList<Int> = mutableListOf()
        while(progressesQ.isNotEmpty()) {
            if(progressesQ.peek() >= 100) {
                var count = 0
                while(true) {
                    if(progressesQ.isEmpty()) break
                    if(progressesQ.isNotEmpty() && progressesQ.peek() < 100) break
                    progressesQ.poll()
                    speedsQ.poll()
                    count++
                }
                result.add(count)
            }
            else if(progressesQ.isNotEmpty() && progressesQ.peek() < 100){
                for(i in progressesQ.indices) {
                    val nowProgress = progressesQ.poll()
                    val addSpeed = speedsQ.poll()
                    progressesQ.add(nowProgress+addSpeed)
                    speedsQ.add(addSpeed)
                }
            }
        }
        return result.toIntArray()
    }

}
