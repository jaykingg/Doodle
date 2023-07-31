/*
    https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */

class Solve21 {
    fun main() {
        println(solution(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)) == 2)
    }

    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        var idx = IntArray(100001) { 0 }
        for (i in topping.indices) {
            idx[topping[i]]++
        }

        val set1 = mutableSetOf<Int>()
        val set2 = topping.toMutableSet()

        for (i in 0 until topping.size) {
            set1.add(topping[i])
            idx[topping[i]]--
            if (idx[topping[i]] <= 0) set2.remove(topping[i])
            if (set1.size == set2.size) answer++
        }
        return answer
    }

}
