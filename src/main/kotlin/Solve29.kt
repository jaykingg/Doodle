import kotlin.math.pow

class Solve29 {
    fun main() {
        println(solution(15))
    }

    fun solution(n: Int): Int {
        return if (n < 10) n
        else {
            var n = n.toLong()
            var (number, cycle, sum) = longArrayOf(9, 1, 9)
            while (n >= (number * 10) * (cycle + 1)) {
                number *= 10
                cycle += 1
                sum += number * cycle
            }

            n -= (sum + 1)
            val makeValue = (10.0.pow(cycle.toDouble()) + n / (cycle + 1)).toLong().toString()
            val whatNumber = n % (cycle + 1)
            return makeValue[whatNumber.toInt()] - '0'
        }

    }

}
