package e_aloha.week3

/**
 * 10th https://www.acmicpc.net/problem/14501
 *
 *
 * 2초이고 n 의 값이 15가 마지막이기 떄문에 시간적 여유가 있음
 */
var max = Integer.MIN_VALUE
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val timeAndPriceMap: HashMap<Int, Pair<Int, Int>> = hashMapOf()

    for (i in 0 until n) {
        val (time, price) = readLine().split(" ").map { it.toInt() }
        timeAndPriceMap[i + 1] = Pair(time, price)
    }

    //TODo for 문 1,2,....7
    dfs(1, ,0, timeAndPriceMap)
}

fun dfs(depth: Int, sum: Int, timeAndPriceMap: HashMap<Int, Pair<Int, Int>>) {
    if (depth > 7) {
        return
    }
    for(i in depth+1 until 7+1) {
        val (time,price) = timeAndPriceMap[i]!!
        val nextDepth = depth + time
        val nextSum = sum + price
        // dfs(...)
        max = maxOf(max, nextSum)
    }


}


