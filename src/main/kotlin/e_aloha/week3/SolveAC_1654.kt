package e_aloha.week3

/**
 * 4th
 * https://www.acmicpc.net/problem/1654
 *
 * 풀어봣을때 어떤 길이를 특정한 길이로 자르고 지지고 볶고 하는 것은 이분탐색일 경우가 많다. (확인은 필요하다.)
 *
 * 가장 긴 랜선을 기준으로, (가장 커야 모든 랜선을 커버할 수 있는 경우의 수가 많음)
 * 이분 탐색을 하며 필요 개수 이상이 될 때까지 탐색한다
 */
fun main() = with(System.`in`.bufferedReader()) {

    val (times, needs) = readLine().split(" ").map { it.toInt() }
    val listOfLan = mutableListOf<Int>()

    repeat(times) {
        val inputLan = readLine().toInt()
        listOfLan.add(inputLan)
    }

    var start = 1L
    var end = listOfLan.max().toLong()
    var result = 0L

    while (start <= end) {
        var count = 0L
        val length = (start + end) / 2

        listOfLan.forEach { count += it / length }

        // 필요 개수를 채울 수 있다면, 최대 길이를 구해야한다.
        if (count >= needs) {
            result = length
            start = length + 1
        } // 필요 개수를 채울 수 없다면, 더 작은 길이로 잘라보아야한다.
        else {
            end = length - 1
        }
    }

    println(result)

}
