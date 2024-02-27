import kotlin.math.min

class Solve38 {
    /*
    Minimum Loss
    https://www.hackerrank.com/challenges/minimum-loss/problem?isFullScreen=true
     */
    fun main() {
        val n = readLine()!!.trim().toInt()
        val price = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()
        val result = minimumLoss(price)
        println(result)
    }

    fun minimumLoss(price: Array<Long>): Int {
        var result: Long = Long.MAX_VALUE
        for (i in 0 until price.size - 1) {
            for (j in i + 1 until price.size) {
                if (price[i] > price[j]) {
                    result = min(result, price[i] - price[j])
                }
            }
        }
        return result.toInt()
    }

}
