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
    var start = 1
    var end = 1
    var max = -1
    val fruit = HashMap<Int, Int>()

    for (i in 1 until 10) {
        fruit[i] = 0
    }

    fruit[list[0]] = 1

    println(list)
    while (end <= list.size) {
        val count = fruit.values.stream().filter { it > 0 }.count()
        if (count < 3) {
            max = maxOf(max, fruit.values.sum())
            fruit[list[end - 1]] = fruit[list[end - 1]]!!.plus(1)
            end++
        } else {
            fruit[list[start - 1]] = fruit[list[start - 1]]!!.minus(1)
            start++
        }
    }

    println(max)

    //fruit.values.stream().filter { it > 0 }.count()

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
