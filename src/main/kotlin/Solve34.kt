class Solve34 {
    /*
        https://www.acmicpc.net/problem/1283
     */
    fun main() {
        val cycle = readln().toInt()
        val box: MutableSet<String> = mutableSetOf()
        val result: ArrayList<String> = arrayListOf()
        for (i in 0 until cycle) {
            var flag = false
            val text = readLine()!!.toString()
            val space = text.split(" ")
            if (space.size == 1) {
                for (idx in text.indices) {
                    if (!box.contains(text[idx].uppercase())) {
                        box.add(text[idx].uppercase())
                        result.add(makeText(text, idx))
                        flag = true
                        break
                    }
                }
                if (!flag) result.add(text)
            } else {
                for (idx in 0 until 10) {
                    for (spaceIdx in space.indices) {
                        //ToDO
                    }
                }

            }

        }

        result.forEach {
            println(it)
        }
    }

    fun makeText(text: String, idx: Int): String {
        val bulder: StringBuilder = StringBuilder()
        for (i in text.indices) {
            if (i == idx) {
                bulder.append("[")
                bulder.append(text[i])
                bulder.append("]")
            } else {
                bulder.append(text[i])
            }
        }
        return bulder.toString()
    }
}