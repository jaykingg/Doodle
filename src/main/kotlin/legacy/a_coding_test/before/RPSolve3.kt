package legacy.a_coding_test.before

class RPSolve3 {

    fun solution(N: Int, coffee_times: IntArray): IntArray {
        val result = IntArray(coffee_times.size)
        val coffeeMakers = Array(N) { Pair(0, it) } // Pair(timeLeft, makerIndex)
        var order = 0

        for (time in coffee_times) {
            if (order < coffee_times.size) {
                val (timeLeft, makerIndex) = coffeeMakers.minByOrNull { it.first }!!
                result[order] = makerIndex + 1
                coffeeMakers[makerIndex] = Pair(timeLeft + time, makerIndex)
                order++
            }
        }

        return result
    }


    fun main() {
        val N = 3
        val coffee_times = intArrayOf(4, 2, 2, 5, 3)
        val result = solution(N, coffee_times)
        println(result.joinToString())
    }


}
