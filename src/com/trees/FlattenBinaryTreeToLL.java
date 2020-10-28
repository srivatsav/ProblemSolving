package com.trees;

public class FlattenBinaryTreeToLL {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        flatten(root);

        while (root != null) {
            System.out.println(root.val + "->");
            root = root.right;
        }
    }

    private static void flatten(Node root) {

        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        flatten(root.left);
        Node temp1 = root.left; // 3
        flatten(root.right);
        Node temp2 = root.right; // 4

        if (temp1 != null) {
            root.left = null;
            root.right = temp1;
            while (temp1.right != null)
                temp1 = temp1.right;
            temp1.right = temp2;
        }

    }
}
