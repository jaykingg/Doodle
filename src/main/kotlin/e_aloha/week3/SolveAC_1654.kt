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

    var left = 1
    var right = listOfLan.max()
    var resultOfLan = 0

    while (left <= right) {
        var count = 0
        val mid = (left + right) / 2

        for (lan in listOfLan) {
            count += lan / mid
        }

        // 필요 개수를 채울 수 있다면, 최대 길이를 구해야한다.
        if (count >= needs) {
            resultOfLan = mid
            left = mid + 1
        } // 필요 개수를 채울 수 없다면, 더 작은 길이로 잘라보아야한다.
        else {
            right = mid - 1
        }
    }

    println(resultOfLan)


}
