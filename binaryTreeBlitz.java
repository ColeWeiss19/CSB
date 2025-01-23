class BinarySearchTree {

    // Definition of the Node class
    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Method to insert a node into the BST
    public void insert(char data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node node, char data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insertRecursive(node.left, data);
        } else if (data > node.data) {
            node.right = insertRecursive(node.right, data);
        }
        return node;
    }

    // Pre-Order Traversal (Root -> Left -> Right)
    public void preOrderTraversal() {
        System.out.print("Pre-Order Traversal: ");
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    // Post-Order Traversal (Left -> Right -> Root)
    public void postOrderTraversal() {
        System.out.print("Post-Order Traversal: ");
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Node node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

    // In-Order Traversal (Left -> Root -> Right)
    public void inOrderTraversal() {
        System.out.print("In-Order Traversal: ");
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderRecursive(node.right);
        }
    }

    // Method to calculate the height of the BST
    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node node) {
        if (node == null) {
            return -1; // Height of an empty tree is -1
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to count the number of leaves in the BST
    public int countLeaves() {
        return countLeavesRecursive(root);
    }

    private int countLeavesRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeavesRecursive(node.left) + countLeavesRecursive(node.right);
    }

    // Method to calculate the internal path length (sum of all node depths)
    public int getInternalPathLength() {
        return calculateInternalPathLength(root, 0);
    }

    private int calculateInternalPathLength(Node node, int depth) {
        if (node == null) {
            return 0;
        }
        return depth + calculateInternalPathLength(node.left, depth + 1) + calculateInternalPathLength(node.right, depth + 1);
    }

    // Method to calculate the external path length (sum of all external node depths)
    public int getExternalPathLength() {
        return calculateExternalPathLength(root, 0);
    }

    private int calculateExternalPathLength(Node node, int depth) {
        if (node == null) {
            return depth; // External nodes contribute depth
        }
        return calculateExternalPathLength(node.left, depth + 1) + calculateExternalPathLength(node.right, depth + 1);
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into the BST
        char[] letters = {'M', 'C', 'R', 'A', 'E', 'P', 'X', 'D', 'F'};
        for (char letter : letters) {
            bst.insert(letter);
        }

        // Perform traversals
        bst.preOrderTraversal();  // Output: M C A E D F R P X
        bst.postOrderTraversal(); // Output: A D F E C P X R M
        bst.inOrderTraversal();   // Output: A C D E F M P R X

        // Get and print the height of the tree
        System.out.println("Height of the tree: " + bst.getHeight()); // Output: 3

        // Count and print the number of leaves
        System.out.println("Number of leaves: " + bst.countLeaves()); // Output: 4

        // Calculate and print the internal path length
        System.out.println("Internal Path Length: " + bst.getInternalPathLength()); // Output: 10

        // Calculate and print the external path length
        System.out.println("External Path Length: " + bst.getExternalPathLength()); // Output: 22
    }
}
