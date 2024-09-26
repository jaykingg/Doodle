package e_aloha.week3

/**
 * 7th https://www.acmicpc.net/problem/30804
 *
 * deque ? 2 pointer ?
 * 시간이 넉넉한 것보다 브루트포스로 그냥 다 하라는 말 같다. -> 응 1트 시간초과
 * 2 pointer 로 푼다
 *
 *  5 1 1 2 1
 *  p
 *    p
 *  ...
 */


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val fruit = IntArray(list.size + 1) { 0 }
    var start = 0
    var end = 0
    var max = Integer.MIN_VALUE

    // 0 ~ 4
    while (end <= list.size) {
        if (start == list.size || end == list.size) break
        var count = fruit.count { it > 0 }
        println("start:: $start, end:: $end, count:: $count, size:: ${list.size}")
        println(fruit.toList())
        if (count < 3 && end < list.size) {
            fruit[list[end]] += 1
            end++
            count++
            if (count == 3) {
                fruit[list[start]] -= 1
                start++
            }
            val sum = fruit.sum()
            max = maxOf(max, sum)

        } else {
            if (start < end && start < list.size) {
                fruit[list[start]] -= 1
                start++
            }
        }
    }
    println(max)
    /**
     *   5
     *   5 1 1 2 1
     * s   1
     * e         4
     */

    /*
        배열 전체를 distinct 했기 때문에 시간초과가 뜬 것이 아닌가
        val n = readLine().toInt()
        val list = readLine().split(" ").map { it.toInt() }
        var start = 0
        var max = Integer.MIN_VALUE

        if (list.distinct().size == 1) {
            println(1)
            return
        }

        for (end in 1 until list.size) {
            val subList = list.subList(start, end)
            if (subList.distinct().size < 3) {
                max = maxOf(max, (end - start))
            } else {
                start++
            }
        }
        println(max)
    */
}
