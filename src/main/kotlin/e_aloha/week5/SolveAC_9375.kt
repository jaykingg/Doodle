package e_aloha.week5

/**
 * https://www.acmicpc.net/problem/9375
 * 패션왕 신해빈
 *
 *
 * 조합 문제
 * 의상을 종류별로 그룹화
 */
fun main() = with(System.`in`.bufferedReader()) {
    val case = readLine().toInt()  // 테스트 케이스 수
    val results = StringBuilder()

    repeat(case) {
        val n = readLine().toInt()
        val clothes = mutableMapOf<String, Int>()

        /**
         * Grouping
         * headgear : 2
         * eyewear : 1
         */
        for (i in 0 until n) {
            val (unnecessaryVariable, type) = readLine().split(" ")
            clothes[type] = clothes.getOrDefault(type, 0) + 1
        }

        var combinations = 1
        for (count in clothes.values) {
            // 의류 수 + "안 입는 것 포함"
            combinations *= (count + 1)
        }

        // 모두 안 입는 경우도 포함되어있으므로 제외
        results.append("${combinations - 1}\n")
    }

    print(results)
}

