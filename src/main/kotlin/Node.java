class Node {
    private Node leftChild, rightChild;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public static void main(String[] args) {
        Node leaf1 = new Node(null, null);
        Node leaf2 = new Node(null, null);
        Node node = new Node(leaf1, null);
        Node root = new Node(node, leaf2);

        System.out.println(root.height()); // prints 2
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public int height() {
        // Base case: If the node is a leaf, its height is 0.
        if (leftChild == null && rightChild == null) {
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        // Recursively calculate the height of the left and right subtrees.
        if (leftChild != null) {
            leftHeight = leftChild.height();
        }
        if (rightChild != null) {
            rightHeight = rightChild.height();
        }

        // Return the maximum height among left and right subtrees plus 1 for the current node.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
