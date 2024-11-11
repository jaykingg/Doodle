package e_aloha.week6

/**
 * https://www.acmicpc.net/problem/1991
 * 트리 순회
 *
 * 이진 트리를 순회하는 방식을 구현.. 재귀 넘 싫음
 */
class BinaryTree {
    private val nodes = mutableMapOf<Char, Triple<Char, Char?, Char?>>()

    fun addNode(value: Char, left: Char?, right: Char?) {
        nodes[value] = Triple(value, left, right)
    }

    // 전위 순회 : root -> left -> right
    fun preorder(node: Char?) {
        // 재귀 break
        if (node == null || node == '.') return
        // root
        print(node)
        val (value, left, right) = nodes[node]!!
        // root 에 left
        preorder(left)
        // root 에 right
        preorder(right)
    }

    // 중위 순화 : left -> root -> right
    fun inorder(node: Char?) {
        if (node == null || node == '.') return
        val (value, left, right) = nodes[node]!!
        inorder(left)
        print(value)
        inorder(right)
    }

    // 후위 순회 : left -> right -> root
    fun postorder(node: Char?) {
        if (node == null || node == '.') return
        val (value, left, right) = nodes[node]!!
        postorder(left)
        postorder(right)
        print(value)
    }

    fun getRoot(): Char = 'A'
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val tree = BinaryTree()

    repeat(n) {
        val (value, left, right) = readLine().split(" ").map { it[0] }
        tree.addNode(value, if (left != '.') left else null, if (right != '.') right else null)
    }

    val root = tree.getRoot()

    tree.preorder(root).also { println() }
    tree.inorder(root).also { println() }
    tree.postorder(root).also { println() }
}
