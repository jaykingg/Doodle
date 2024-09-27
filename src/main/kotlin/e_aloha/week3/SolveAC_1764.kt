package e_aloha.week3

/**
 *  8th https://www.acmicpc.net/problem/1764
 *
 *
 *  n 을 우선 저장, m 을 저장할 때 확인하면서 "듣도보도 못한" 값을 저장(2)
 *  2 인것들만 filter
 *  n*m 의 복잡도가 나오지않도록 하는것이 관건인 것 같음
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, Int>()

    repeat(n) {
        val listen = readLine().toString()
        map[listen] = 1
    }

    repeat(m) {
        val look = readLine().toString()
        if (map.contains(look)) map[look] = 2
        else map[look] = 1
    }

    val result = map.filter { it.value == 2 }.keys.toList().sorted()

    println(result.size)
    result.forEach { println(it) }

}
