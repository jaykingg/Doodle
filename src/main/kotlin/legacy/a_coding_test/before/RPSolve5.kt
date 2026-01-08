package legacy.a_coding_test.before

class RPSolve5 {
    fun maxListenedSongs(play_list: IntArray, listen_time: Int): Int {
        val n = play_list.size
        var maxSongs = 0
        var totalTime = 0
        var start = 0

        for (end in 0 until n) {
            totalTime += play_list[end]

            while (totalTime > listen_time) {
                totalTime -= play_list[start]
                start++
            }

            maxSongs = maxOf(maxSongs, end - start + 1)
        }

        return maxSongs
    }


    fun main() {
        val play_list = intArrayOf(2, 3, 1, 4)
        val listen_time = 3
        val result = maxListenedSongs(play_list, listen_time)
        println(result)
    }


}
