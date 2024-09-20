package e_aloha

/**
 * https://www.acmicpc.net/problem/2869
 */

fun main() = with(System.`in`.bufferedReader()) {
    /**
     * 시간을 보면 반복문을 사용하면 안되는 시간 초이다.
     */
    val (up, down, height) = readLine()!!.split(" ").map { it.toInt() }
    var day = 0
    /* A = 올라갈 수 있는 거리 , B = 미끄러지는 거리 , V= 나무막대 높이
    *  올라가야할 거리 = V-B 하루에 갈 수 있는 거리 = A - B
    * */
    day = (height - down) / (up - down)

    /**
     * 정상에 올라간 경우 미끄러지지 않는다
     * */
    if ((height - down) % (up - down) > 0) day++
    println(day)

//    while (true) {
//        day++
//        height -= up
//        if (height <= 0) break
//        height += down
//    }
//    println(day)
}

