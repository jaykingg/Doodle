package legacy.d_hacker_rank

import kotlin.math.max

class HR_Designer_Pdf_Viewer {
    /*
        Designer PDF Viewer
        https://www.hackerrank.com/challenges/designer-pdf-viewer/problem?isFullScreen=false

        input:

        1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
        abc

        result:
        9
     */
    fun main() {

        val h = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        val word = readLine()!!

        val result = designerPdfViewer(h, word)

        println(result)
    }

    fun designerPdfViewer(h: Array<Int>, word: String): Int {
        var max = 0
        for (i in 0 until word.length) {
            max = max(max, h.get(word[i] - 'a'))
        }
        return max * word.length
    }

}
