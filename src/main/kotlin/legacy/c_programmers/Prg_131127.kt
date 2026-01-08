package legacy.c_programmers

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
class Prg_131127 {
    fun main() {
        val want = arrayOf("banana", "apple", "rice", "pork", "pot")
        val number = intArrayOf(3, 2, 2, 2, 1)
        val discount = arrayOf(
            "chicken",
            "apple",
            "apple",
            "banana",
            "rice",
            "apple",
            "pork",
            "banana",
            "pork",
            "rice",
            "pot",
            "banana",
            "apple",
            "banana"
        )
        println(solution(want, number, discount))
    }

    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        for (i in 0 until discount.size - 10 + 1) {
            // 0 1 2 3 4 5 6 7 8 9 10 11 12 13
            println(discount.size)
            if (!want.contains(discount[i])) continue
            val map = mutableMapOf<String, Int>()
            for (j in want.indices) {
                map[want[j]] = number[j]
            }


            for (j in i until i + 10) {
                if (map.containsKey(discount[j]) && map[discount[j]]!! > 0) {
                    map[discount[j]] = map[discount[j]]!! - 1
                }
                println(map)
            }

            var result = 0
            map.forEach {
                result += it.value
            }

            if (result == 0) answer++
        }
        return answer
    }

}
