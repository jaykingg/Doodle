package e_aloha.week3

/**
 * 10th https://www.acmicpc.net/problem/14501
 *
 *
 * 2초이고 n 의 값이 15가 마지막이기 떄문에 시간적 여유가 있음
 */
var max = Integer.MIN_VALUE
var n = -1
var sum = 0
val timeAndPriceMap: HashMap<Int, Pair<Int, Int>> = hashMapOf()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    for (i in 0 until n) {
        val (time, price) = readLine().split(" ").map { it.toInt() }
        timeAndPriceMap[i] = Pair(time, price)
    }

    for (i in 0 until n) {
        dfs(i, timeAndPriceMap[i]!!.first)
    }
    println(max)
}


fun dfs(day: Int, next: Int) {
    if (day + next == n) {
        sum += timeAndPriceMap[day]!!.second
        max = maxOf(max, sum)
        sum = 0
    } else if (day + next > n) {
        max = maxOf(max, sum)
        sum = 0
    } else {
        sum += timeAndPriceMap[day]!!.second
        val temporary = sum
        for (i in (day + next) until n) {
            sum = temporary
            dfs(i, timeAndPriceMap[i]!!.first)
        }
    }

}



