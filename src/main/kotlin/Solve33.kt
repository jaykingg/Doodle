class Solve33 {
    fun main() {
        println(solution(arrayOf("0-0", "0-1", "2-3", "2-0")))
        //println(solution(arrayOf("0-0", "1-1", "2-2", "3-3", "4-4", "5-5", "6-6")))
    }

    fun solution(A: Array<String>): String {
        val dominoSet: MutableSet<Pair<Int, Int>> = mutableSetOf()

        for (firstTile in 0..6) {
            for (secondTile in 0..6) {
                dominoSet.add(Pair(firstTile, secondTile))
            }
        }

        for (tileIndex in A.indices) {
            val (removeFirstTile, removeSecondTile) = A[tileIndex].split("-").map { it.toInt() }
            if (removeFirstTile == removeSecondTile) {
                dominoSet.remove(Pair(removeFirstTile, removeSecondTile))
            } else {
                dominoSet.remove(Pair(removeFirstTile, removeSecondTile))
                dominoSet.remove(Pair(removeSecondTile, removeFirstTile))

            }
        }

        val resultPair = dominoSet.first()
        return resultPair.first.toString() + "-" + resultPair.second
    }

}
