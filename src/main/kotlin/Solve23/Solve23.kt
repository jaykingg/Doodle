package Solve23
/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
class Solve23 {
    fun main() {
        val arr: Array<Array<String>> = arrayOf(arrayOf("yellow_hat", "headgear"), arrayOf("blue_sunglasses", "eyewear"), arrayOf("green_turban", "headgear"))
        println(solution(arr) == 5)
        val arr2: Array<Array<String>> = arrayOf(arrayOf("crow_mask", "face"), arrayOf("blue_sunglasses", "face"), arrayOf("smoky_makeup", "face"))
        println(solution(arr2) == 3)

    }

    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1

        val map = hashMapOf<String,Int>()
        for(i in clothes.indices) {
            val name = clothes[i][0]
            val category = clothes[i][1]
            if(map.containsKey(category)) {
                map[category] = map[category]!!.plus(1)
            }
            else {
                map[category] = 1
            }
        }

        map.keys.forEach {
            answer *= (map[it]!! + 1)
        }

        return answer-1
    }

}
