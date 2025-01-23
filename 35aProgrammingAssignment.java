// Lab35ast.java
// Enhanced Graphical Binary Tree Program

import java.awt.*;
import java.awt.event.*;

public class Lab35ast {
    public static void main(String args[]) {
        GfxApp gfx = new GfxApp();
        gfx.setSize(800, 600);
        gfx.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        gfx.show();
    }
}

class GfxApp extends Frame {
    private int td = 500; // Time delay to slow down graphics display
    private GfxTreeNode root;

    public void paint(Graphics g) {
        g.setFont(new Font("ARIAL", Font.BOLD, 20));
        displayTitle(g, "DRAWING A BINARY TREE");

        // Insert nodes into the BST
        char[] nodes = {'M', 'G', 'D', 'S', 'P', 'A', 'F', 'Q', 'J', 'H', 'K', 'W', 'T', 'N', 'Z'};
        for (char node : nodes) {
            root = insertNode(g, root, node, 400, 100, 160, 0);
        }

        // Perform traversals
        displayProcess(g, "Traversals:");
        String preOrder = preOrderTraversal(root);
        String inOrder = inOrderTraversal(root);
        String postOrder = postOrderTraversal(root);
        displayOutput(g, "Pre-Order: " + preOrder);
        displayOutput(g, "In-Order: " + inOrder);
        displayOutput(g, "Post-Order: " + postOrder);

        // Calculate and display additional tree properties
        int height = calculateHeight(root);
        int leafCount = countLeaves(root);
        int internalPathLength = calculateInternalPathLength(root, 0);
        int externalPathLength = calculateExternalPathLength(root, 0);

        displayOutput(g, "Height: " + height);
        displayOutput(g, "Leaf Count: " + leafCount);
        displayOutput(g, "Internal Path Length: " + internalPathLength);
        displayOutput(g, "External Path Length: " + externalPathLength);
    }

    // Display methods
    public void displayTitle(Graphics g, String t) {
        g.setColor(Color.black);
        g.drawString(t, 50, 50);
    }

    public void displayProcess(Graphics g, String p) {
        g.setColor(Color.black);
        g.drawString(p, 100, 500);
    }

    public void displayOutput(Graphics g, String output) {
        g.setColor(Color.black);
        g.drawString(output, 100, 570);
        delay();
    }

    // Insert node into the BST
    private GfxTreeNode insertNode(Graphics g, GfxTreeNode root, char data, int x, int y, int dx, int clr) {
        if (root == null) {
            GfxTreeNode node = new GfxTreeNode(g, x, y, clr, td);
            node.enterData(g, data, clr);
            return node;
        }
        if (data < root.getLetter()) {
            GfxTreeNode leftChild = insertNode(g, null, data, x - dx, y + 60, dx / 2, clr + 1);
            root.drawLeftLink(g, leftChild, clr);
            root.left = leftChild;
        } else {
            GfxTreeNode rightChild = insertNode(g, null, data, x + dx, y + 60, dx / 2, clr + 1);
            root.drawRightLink(g, rightChild, clr);
            root.right = rightChild;
        }
        return root;
    }

    // Traversal methods
    private String preOrderTraversal(GfxTreeNode node) {
        if (node == null) return "";
        return node.getLetter() + preOrderTraversal(node.left) + preOrderTraversal(node.right);
    }

    private String inOrderTraversal(GfxTreeNode node) {
        if (node == null) return "";
        return inOrderTraversal(node.left) + node.getLetter() + inOrderTraversal(node.right);
    }

    private String postOrderTraversal(GfxTreeNode node) {
        if (node == null) return "";
        return postOrderTraversal(node.left) + postOrderTraversal(node.right) + node.getLetter();
    }

    // Height calculation
    private int calculateHeight(GfxTreeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }

    // Leaf counting
    private int countLeaves(GfxTreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // Internal path length
    private int calculateInternalPathLength(GfxTreeNode node, int depth) {
        if (node == null) return 0;
        return depth + calculateInternalPathLength(node.left, depth + 1) + calculateInternalPathLength(node.right, depth + 1);
    }

    // External path length
    private int calculateExternalPathLength(GfxTreeNode node, int depth) {
        if (node == null) return depth;
        return calculateExternalPathLength(node.left, depth + 1) + calculateExternalPathLength(node.right, depth + 1);
    }

    // Time delay
    private void delay() {
        for (double k = 1; k < td; k += 0.00001) ;
    }
}
