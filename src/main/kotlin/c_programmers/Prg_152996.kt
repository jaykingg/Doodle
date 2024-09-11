package c_programmers

import java.util.*
import kotlin.collections.HashMap

class Prg_152996 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/152996
     * 시소 짝궁
     */
    fun main() {
        println(solution(intArrayOf(100,180,360,100,270)).toInt() == 4)
    }

    /**
     *  X : a = Y : b
     *  Ya = Xb
     *  Y = Xb/a
     *  Y = X
     *  Y = X/2
     *  Y = 2X/3
     *  Y = 3X/4
     *  ex y = 270, 360
     */
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        Arrays.sort(weights)
        val map: HashMap<Double, Int> = hashMapOf()

        for(i in weights.indices) {
            if(map.containsKey(weights[i] * 1.0)) answer += map[weights[i] * 1.0]!!.toLong()
            if(map.containsKey((weights[i] * 1.0) / 2.0)) answer += map[((weights[i] * 1.0) / 2.0)]!!.toLong()
            if(map.containsKey((weights[i] * 2.0) / 3.0)) answer += map[(weights[i] * 2.0) / 3.0]!!.toLong()
            if(map.containsKey((weights[i] * 3.0) / 4.0)) answer += map[((weights[i] * 3.0) / 4.0)]!!.toLong()
            map[weights[i] * 1.0] = map.getOrDefault(weights[i] * 1.0, 0) + 1
        }
        return answer
    }
}
