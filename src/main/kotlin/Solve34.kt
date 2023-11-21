class Solve34 {
    /*
        https://www.acmicpc.net/problem/1283
     */
    fun main() {
        val cycle = readLine()!!.toInt()
        val box: MutableSet<String> = mutableSetOf()
        val result: MutableList<String> = mutableListOf()
        val wordArray:Array<String> = Array(cycle){""}
        for(cycleIdx in 0 until cycle) {
            val word = readLine()!!
            wordArray[cycleIdx] = word
        }

        for(wordIdx in wordArray.indices) {
            val word = wordArray[wordIdx]
            val wordSplit: MutableList<String> = word.split(" ").toMutableList()
            var idx = -1
            val addChar = null

            for(i in wordSplit.indices) {
                for(j in )
            }

        }

        result.forEach {
            println(it)
        }
    }

    fun makeWord(word: String, idx: Int) : String {
        return "11"
    }

    fun attachWords(words: MutableList<String>) : String {
        return "11"
    }
}