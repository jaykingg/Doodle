package e_aloha.week3

import java.util.*

/**
 * 3rd
 * https://www.acmicpc.net/problem/1966
 *
 *
 * 처음에 Priority Queue 인 것으로 판단했으나 priority 순서대로 정렬했을 때 원하는 값이 나오지 않음
 *
 * Queue 를 이용한 단순 구현 문제이다.
 * 입력 값을 Queue 에 넣는다. Pair(index, 중요도)
 * queue 에서 값을 꺼낸 값의 중요도가 가장 큰 값인지 확인한다
 * 꺼낸 것의 중요도보다 큰 겂이 있다면 뒤로 보낸다(가장 중요도한 것이 아니므로)
 */
fun main() = with(System.`in`.bufferedReader()) {
    val testCase = readLine().toInt()

    repeat(testCase) {
        val (numberOfBooks: Int, position: Int) = readLine().split(" ").map { it.toInt() }
        val sequence = readLine().split(" ").map { it.toInt() }.toList()
        println(getSequence(position, sequence))
    }
}

fun getSequence(position: Int, sequence: List<Int>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var result = 0

    for (i in sequence.indices) {
        queue.add(Pair(i, sequence[i]))
    }

    while (sequence.isNotEmpty()) {
        val (index, priority) = queue.poll()
        if (queue.any { it.second > priority }) {
            queue.add(Pair(index, priority))
        } else {
            result++
            if (index == position) {
                break
            }
        }
    }

    return result
}

