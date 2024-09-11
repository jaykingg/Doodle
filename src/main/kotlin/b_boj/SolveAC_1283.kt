package b_boj

class SolveAC_1283 {
    /*
        https://www.acmicpc.net/problem/1283
     */
    fun main() {
        val cycle = readLine()!!.toInt()
        val key: MutableSet<String> = mutableSetOf()

        for (i in 0 until cycle) {
            val word: MutableList<String> = readLine()!!.split(" ").toMutableList()
            var flag = false
            loop@ for (j in word.indices) {
                if (!key.contains(word[j][0].uppercase())) {
                    flag = true
                    key.add(word[j][0].uppercase())
                    word[j] = "[${word[j][0]}]${word[j].substring(1, word[j].length)}"
                    break@loop
                }
            }

            if (!flag) {
                loop@ for (j in word.indices) {
                    for (k in word[j].indices) {
                        if (k == 0) {
                            continue
                        } else {
                            if (!key.contains(word[j][k].uppercase())) {
                                key.add(word[j][k].uppercase())
                                word[j] = "${word[j].substring(0, k)}[${word[j][k]}]${
                                    word[j].substring(
                                        k + 1,
                                        word[j].length
                                    )
                                }"
                                break@loop
                            }
                        }
                    }
                }
            }
            println(word.joinToString(" "))
        }
    }
}
