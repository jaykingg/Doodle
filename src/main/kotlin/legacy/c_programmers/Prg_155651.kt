package legacy.c_programmers

class Prg_155651 {
    /*
     똥멍청이 색기야 문제에서 10분 더하라고하면
     57 + 10 = 67분이냐 ? 생각좀해라^^
     */
    fun main() {
        val book_time: Array<Array<String>> =
            arrayOf(
                arrayOf("15:00", "17:00"),
                arrayOf("16:40", "18:20"),
                arrayOf("14:20", "15:20"),
                arrayOf("14:10", "19:20"),
                arrayOf("18:20", "21:20")
            )
        println("expected:3 /" + solution(book_time))

        val book_time2: Array<Array<String>> =
            arrayOf(
                arrayOf("09:10", "10:10"),
                arrayOf("10:20", "12:20"),
            )
        println("expected:1 /" + solution(book_time2))


        val book_time3: Array<Array<String>> =
            arrayOf(
                arrayOf("10:20", "12:30"),
                arrayOf("10:20", "12:30"),
                arrayOf("10:20", "12:30"),
            )
        println("expected:3 /" + solution(book_time3))

    }

    fun solution(book_time: Array<Array<String>>): Int {
        book_time.sortBy { it[0] }
        book_time.forEach { it ->
            it[0] = (it[0].split(":")[0].toInt().times(60) + it[0].split(":")[1].toInt()).toString()
            it[1] = (it[1].split(":")[0].toInt().times(60) + it[1].split(":")[1].toInt().plus(10)).toString()
        }

        val rooms: MutableList<ArrayList<String>> = mutableListOf()

        for (enterIdx in book_time.indices) {
            if (enterIdx == 0) {
                rooms.add(arrayListOf(book_time[enterIdx][0], book_time[enterIdx][1]))
            } else {
                for (cpIdx in 0 until rooms.size) {
                    if ((book_time[enterIdx][0].toInt() < rooms[cpIdx][1].toInt()) && cpIdx == rooms.size - 1) {
                        rooms.add(arrayListOf(book_time[enterIdx][0], book_time[enterIdx][1]))
                    } else if (book_time[enterIdx][0].toInt() >= rooms[cpIdx][1].toInt()) {
                        rooms[cpIdx] = arrayListOf(book_time[enterIdx][0], book_time[enterIdx][1])
                        break;
                    }
                }
            }
        }

        return rooms.size
    }
}
