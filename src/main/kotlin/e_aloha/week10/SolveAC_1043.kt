package e_aloha.week10

/**
 * https://www.acmicpc.net/problem/1043
 * 거짓말
 */
fun main() {
    /**
     * 어떤 사람이 어떤 파티에서는 진실을 듣고, 또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다.
     */
    val (n, m) = readln().split(" ").map { it.toInt() }

    // 진실을 아는 사람들 정보
    val peopleWhoKnowTruth = readln().split(" ").map { it.toInt() }
    val peopleKnownTruthCount = peopleWhoKnowTruth[0]

    // 진실을 아는 사람들
    val knownTruthSet = mutableSetOf<Int>()
    if (peopleKnownTruthCount > 0) {
        // 아는 사람들의 번호 다 넣음
        knownTruthSet.addAll(peopleWhoKnowTruth.drop(1))
    }

    // 각 파티의 참석자 저장
    val parties = mutableListOf<List<Int>>()
    repeat(m) {
        val people = readln().split(" ").drop(1).map { it.toInt() }
        parties.add(people)
    }

    // 진실을 아는 사람과 같은 파티에 있는 사람도 진실을 알게 됨 → 전염처럼 확산
    var changed: Boolean
    do {
        changed = false
        for (party in parties) {
            // 이 파티에 진실 아는 사람이 1명이라도 있다면
            if (party.any { it in knownTruthSet }) {
                for (person in party) {
                    // 새로 전파되는 사람이 있다면 Set에 추가하고 확산 flag 설정
                    if (person !in knownTruthSet) {
                        knownTruthSet.add(person)
                        // 다음 루프도 돌게 false 로 떨어질 때가지 반복
                        changed = true
                    }
                }
            }
        }
    } while (changed)

    val msgOkCount = parties.count { party ->
        // knownTruth 에 속한 사람이 아무도 없다면 카운트
        party.none { it in knownTruthSet }
    }

    println(msgOkCount)
}
