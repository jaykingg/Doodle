package e_aloha.week4

/**
 * 마인크래프트
 * https://www.acmicpc.net/problem/18111
 *
 * 500*500*256 = 64,000,000 3 for 문 돌려도 가능
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, B) = readLine()!!.split(" ").map { it.toInt() }
    val blockArray = Array(N) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    var min = Int.MAX_VALUE
    var resultHeight = 0

    // 가능한 모든 높이(0 ~ 256)에 대해 검사
    for (height in 0..256) {
        var time = 0
        var inventory = B

        for (i in 0 until N) {
            for (j in 0 until M) {
                val diff = blockArray[i][j] - height

                // 해당 블록의 수에서 기준 높이를 뺀 것을 비교
                // ex) 블록의 높이가 10이고 기준높이가 5일 때 a-b 를하면 기준 높이가 되고자 하는 값이 됨
                /*
                  ㅇㅇㅇㅇㅇㅇㅇㅇㅇ < 입력받은 블록 높이
                  ㅇㅇㅇ         < 기준 높이
                      ㅇㅇㅇㅇㅇㅇ < 이만큼을 빼줘야야 기준 높이가 된다
                 */
                if (diff > 0) {
                    time += diff * 2
                    inventory += diff
                }
                // 반대로 부족하면 블록을 추가해주어야한다
                else if (diff < 0) {
                    time += -diff
                    inventory += diff
                }
            }
        }

        // 인벤토리의 블록이 충분한 경우, 해당 높이를 계산 한값을 min 에 넣어준다
        if (inventory >= 0 && time <= min) {
            min = time
            resultHeight = height
        }
    }

    println("$minTime $optimalHeight")
}
