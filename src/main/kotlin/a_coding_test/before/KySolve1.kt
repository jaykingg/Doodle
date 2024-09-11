package a_coding_test.before

class KySolve1 {
    fun main() {
        val n = 8
        val containers = arrayOf(11, -9, 2, 5, 18, 17, -15, 4)

        containers.sortByDescending { Math.abs(it) }

        var maxFloors = 1
        var prevContainer = containers[0]



        for (i in 1 until n) {
            if (prevContainer > 0 && containers[i] < 0) {
                maxFloors++
                prevContainer = containers[i]
            } else if (prevContainer < 0 && containers[i] > 0) {
                maxFloors++
                prevContainer = containers[i]
            } else {
                continue
            }
        }

        println(maxFloors)
    }

}
