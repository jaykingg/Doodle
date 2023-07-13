import java.util.LinkedList
import java.util.Queue

class Solve25 {
    fun main() {
        println(solution(6,17,
            arrayOf(
            intArrayOf(5,4,6),
            intArrayOf(5,2,5),
            intArrayOf(0,4,2),
            intArrayOf(2,3,3),
            intArrayOf(1,2,7),
            intArrayOf(0,1,3)
            )
        ).joinToString(" "))

        println(solution(4,10,
            arrayOf(
                intArrayOf(0,1,2),
                intArrayOf(0,2,3)
            )
        ).joinToString(" "))
    }

    fun solution(n: Int, k: Int, roads: Array<IntArray>) : IntArray {
        /*
            비공개
         */
    }

}
