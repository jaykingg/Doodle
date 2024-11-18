package e_aloha.week7

/**
 * https://www.acmicpc.net/problem/12865
 * 평범한 배낭
 *
 * 브루트 포스
 * 시간 초과 뜸 ㅎ
 * DP 인거 같은데 안 할래
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val items = List(n) {
        val (weight, value) = readLine().split(" ").map { it.toInt() }
        weight to value
    }

    println(maxValue(items, k, 0, 0))
}

fun maxValue(
    items: List<Pair<Int, Int>>,
    remainingWeight: Int,
    index: Int,
    currentValue: Int
): Int {
    if (index == items.size) return currentValue

    val (weight, value) = items[index]
    var maxValue = currentValue

    maxValue = maxOf(maxValue, maxValue(items, remainingWeight, index + 1, currentValue))

    if (remainingWeight >= weight) {
        maxValue = maxOf(
            maxValue,
            maxValue(items, remainingWeight - weight, index + 1, currentValue + value)
        )
    }

    return maxValue
}

