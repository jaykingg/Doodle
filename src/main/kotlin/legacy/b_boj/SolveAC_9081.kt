package legacy.b_boj

class SolveAC_9081 {
    /*
    https://www.acmicpc.net/problem/9081 단어맞추기 순열
     */
    fun main() {
        solution()
    }

    fun solution() {
        val line = readLine()!!.toInt()
        val words = mutableListOf<String>()

        repeat(line) {
            words.add(readLine()!!)
        }

        for (idx in words.indices) {
            val word = words[idx].toCharArray()

            var idx1: Int = -1
            var idx2: Int = -1
            var temp: Char
            for (i in word.size - 1 downTo 1) {
                if (word[i - 1] < word[i]) {
                    idx1 = i - 1
                    break
                }
            }

            if (idx1 == -1) {
                println(word)
            } else {
                for (i in word.size - 1 downTo idx1 + 1) {
                    if (word[idx1] < word[i]) {
                        idx2 = i
                        break
                    }
                }
                temp = word[idx1]
                word[idx1] = word[idx2]
                word[idx2] = temp

                word.sort(idx1 + 1, word.size)
                println(word)
            }
        }
    }

}
