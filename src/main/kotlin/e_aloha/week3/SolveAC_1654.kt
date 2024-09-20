package e_aloha.week3

/**
 * 4th
 * https://www.acmicpc.net/problem/1654
 */
fun main() = with(System.`in`.bufferedReader()) {
    /**
     * 가장 큰 랜선의 길이를 기준으로 최적의 값을 찾아냄
     * 가장 큰 길이로 해야 모든 랜선 길이를 커버할 수 있음
     */
    val (haveLANs, requiredLANs) = readLine().split(" ").map { it.toInt() }
    val listOfLANs = mutableListOf<Int>()

    repeat(haveLANs) {
        val lengthOfLAN = readLine().toInt()
        listOfLANs.add(lengthOfLAN)
    }

    var left = 1
    var right = listOfLANs.max()
    var result = 0

    while (left <= right) {
        val mid = (left + right) / 2
        var count = 0

        for (cable in listOfLANs) {
            count += cable / mid
        }

        if (count >= requiredLANs) {
            result = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(result)


}
