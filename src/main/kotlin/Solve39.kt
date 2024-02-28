class Solve39 {
    /*
    Sherlock and the Valid String
    https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true
     */
    fun isValid(s: String): String {
        var index: IntArray = IntArray(26) { 0 }
        for (element in s) {
            index[element - 'a']++
        }

        index = index.filter { it > 0 }.sortedDescending().toIntArray()

        if (index.size < 3) {
            return "YES"
        }

        index.forEach { println(it) }

        if (index[0] == index[1]) {
            if (index[index.size - 1] == index[0]) {
                return "YES"
            } else if (index[index.size - 2] == index[0] && index[index.size - 1] == 1) {
                return "YES"
            }
            return "NO"
        } else {
            if (index[0] - index[1] > 1) {
                return "NO"
            } else if (index[index.size - 1] == index[1]) {
                return "YES"
            }
            return "NO"
        }
    }

    fun main() {
        val s = readLine()!!

        val result = isValid(s)

        println(result)
    }
}
