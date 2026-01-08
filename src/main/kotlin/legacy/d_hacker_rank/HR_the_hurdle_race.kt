package legacy.d_hacker_rank

import kotlin.math.max

class HR_the_hurdle_race {
    fun main() {
        /*
            5 4
            1 6 3 5 2

            result : 2

            https://www.hackerrank.com/challenges/the-hurdle-race/problem?isFullScreen=false
         */
        val input = readLine()!!.trimEnd().split(" ")

        val n = input[0].toInt()

        val k = input[1].toInt()

        val height = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        val result = hurdleRace(k, height)

        println(result)
    }

    fun hurdleRace(k: Int, height: Array<Int>): Int {
        var result: Int = 0
        for (i in height.indices) {
            if (i < k) {
                result = max(height[i] - k, result)
            }
        }
        return result
    }
}
