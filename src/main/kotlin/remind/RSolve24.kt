package remind

class RSolve24 {
    companion object {
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
            val cart: MutableMap<String, Int> = mutableMapOf()

            for (i in want.indices) {
                cart[want[i]] = number[i]
            }

            for (i in 0 until discount.size - 10 + 1) {
                val cartTemp: MutableMap<String, Int> = cart
                if (!cartTemp.containsKey(discount[i])) continue
                for (j in i until i + 10) {
                    if (cartTemp.containsKey(discount[j]) && cartTemp[discount[j]]!! > 0) {
                        cartTemp[discount[j]] = cartTemp[discount[j]]!! - 1
                    }
                }
                if (cartTemp.values.sum() == 0) answer++
            }
            return answer
        }
    }
}