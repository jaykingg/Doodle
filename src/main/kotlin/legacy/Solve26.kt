package legacy

import kotlin.math.abs

class Solve26 {
    fun main() {
        println(solution(intArrayOf(10, 40, 30, 20), 20))
        answer = Integer.MAX_VALUE
        println(solution(intArrayOf(3, 7, 2, 8, 6, 4, 5, 1), 3))
    }

    var answer = Integer.MAX_VALUE
    fun solution(numbers: IntArray, k: Int): Int {
        makeArr(numbers, k, 0, 0)
        return if (answer == Integer.MAX_VALUE) -1 else answer
    }

    private fun makeArr(numbers: IntArray, k: Int, depth: Int, count: Int) {
        if (depth == numbers.size) {
            if (check(numbers, k)) {
                answer = answer.coerceAtMost(count)
            }
        }
        for (i in depth until numbers.size) {
            swap(numbers, depth, i)
            if (depth != i) {
                makeArr(numbers, k, depth + 1, count + 1)
            } else {
                makeArr(numbers, k, depth + 1, count)
            }
            swap(numbers, depth, i)
        }
    }

    private fun swap(forSwapArr: IntArray, a: Int, b: Int) {
        val temp = forSwapArr[a]
        forSwapArr[a] = forSwapArr[b]
        forSwapArr[b] = temp
    }

    private fun check(forCheckArr: IntArray, k: Int): Boolean {
        for (i in 1 until forCheckArr.size - 1) {
            if (abs(forCheckArr[i] - forCheckArr[i - 1]) > k || abs(forCheckArr[i + 1] - forCheckArr[i]) > k) return false
        }
        return true
    }

}
