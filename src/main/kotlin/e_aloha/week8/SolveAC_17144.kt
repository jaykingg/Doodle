package e_aloha.week8

/**
 * https://www.acmicpc.net/problem/17144
 * 미세 먼지 안녕!
 *
 *
 */

fun main() {
    val (r, c, t) = readLine()!!.split(" ").map { it.toInt() }
    val room = Array(r) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    // 공기청정기의 위치 저장
    val airCleaner = room.indices.filter { room[it][0] == -1 }

    // T초 동안 시뮬레이션 실행
    repeat(t) {
        spreadDust(room, r, c)
        operateAirCleaner(room, airCleaner, r, c)
    }

    // 남아있는 미세먼지 총량 계산
    val totalDust = room.sumOf { it.sum() } + 2 // 공기청정기의 -1 값 보정
    println(totalDust)
}

// 미세먼지 확산 함수
fun spreadDust(room: Array<IntArray>, r: Int, c: Int) {
    val temp = Array(r) { room[it].copyOf() } // 기존 배열 복사
    val directions = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (room[i][j] > 0) {
                val spreadAmount = room[i][j] / 5
                var spreadCount = 0
                for ((dx, dy) in directions) {
                    val nx = i + dx
                    val ny = j + dy
                    if (nx in 0 until r && ny in 0 until c && room[nx][ny] != -1) {
                        temp[nx][ny] += spreadAmount
                        spreadCount++
                    }
                }
                temp[i][j] -= spreadAmount * spreadCount
            }
        }
    }

    for (i in 0 until r) {
        for (j in 0 until c) {
            room[i][j] = temp[i][j]
        }
    }
}

// 공기청정기 작동 함수
fun operateAirCleaner(room: Array<IntArray>, airCleaner: List<Int>, r: Int, c: Int) {
    val upper = airCleaner[0]
    val lower = airCleaner[1]

    // 위쪽 공기청정기 (반시계 방향)
    for (i in upper - 1 downTo 1) room[i][0] = room[i - 1][0]
    for (j in 0 until c - 1) room[0][j] = room[0][j + 1]
    for (i in 0 until upper) room[i][c - 1] = room[i + 1][c - 1]
    for (j in c - 1 downTo 1) room[upper][j] = room[upper][j - 1]
    room[upper][1] = 0

    // 아래쪽 공기청정기 (시계 방향)
    for (i in lower + 1 until r - 1) room[i][0] = room[i + 1][0]
    for (j in 0 until c - 1) room[r - 1][j] = room[r - 1][j + 1]
    for (i in r - 1 downTo lower + 1) room[i][c - 1] = room[i - 1][c - 1]
    for (j in c - 1 downTo 1) room[lower][j] = room[lower][j - 1]
    room[lower][1] = 0

    // 공기청정기 위치 값 복구
    room[upper][0] = -1
    room[lower][0] = -1
}
