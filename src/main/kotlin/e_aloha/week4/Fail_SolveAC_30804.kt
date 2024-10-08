package e_aloha.week4

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
 *  시간초과 10번 정도 뜬듯
 *  n^2 면 시간초과 발생함
 */


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val fruit = IntArray(list.size) { 0 }
    var start = 0
    var end = 0
    var count = 0
    var max = Integer.MIN_VALUE
    
    while (end < n) {
        println("start:: $start, end:: $end, count:: $count, size:: ${list.size}")
        println(fruit.toList())
        if (count < 3) {
            // count 랑 sum 을 빼야함
            val sum = fruit.sum() // 여기가 문젠가?
            max = maxOf(max, end - start + 1)
            if (fruit[list[end] - 1] == 0) {
                count++
            }
            fruit[list[end] - 1] += 1
            end++
        } else {
            if (--fruit[list[start] - 1] == 0) {
                count--
            }
            start++
        }
    }
    println(max)
}

