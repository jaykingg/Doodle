package e_aloha.week6

/**
 * https://www.acmicpc.net/problem/11399
 * ATM
 *
 * 빨리 끝낼 수 있는 사람부터 끝내면된다 -> 오름차순으로 정렬
 * [1, 2, 3, 3, 4]
 *
 * 정렬 했을 때 i 번째사람은 몇 분만에 인출해서 나갈 수 있는지를 구함\
 * i 번째 사람 = 내가 인출할때 걸리는 시간 + 이전 사람'들'이 인출에 걸린 시간
 * [1, 3, 6, 9, 13]
 * 이걸 다 더하면 됨
 */
fun main() = with(System.`in`.bufferedReader()) {
    val time = readLine().toInt()
    var atm = readLine().split(" ").map { it.toInt() }
    val calculateArray = IntArray(time) { 0 }
    var result = 0

    atm = atm.sorted()
    calculateArray[0] = atm[0]
    for (i in 1 until atm.size) {
        calculateArray[i] = atm[i] + calculateArray[i - 1]
    }

    println(atm)
    println(calculateArray.joinToString(", "))

    calculateArray.forEach {
        result += it
    }
    println(result)
}
