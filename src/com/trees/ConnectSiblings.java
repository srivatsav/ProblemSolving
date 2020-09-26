package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSiblings {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        connectSiblings(root);

        root.printSiblingLinks(root);

    }

    private static void connectSiblings(Node root) {
        Node previousNode = null;
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node currentNode = q.poll();

                if (previousNode != null)
                    previousNode.next = currentNode;
                previousNode = currentNode;

                if (currentNode.left != null)
                    q.offer(currentNode.left);

                if (currentNode.right != null)
                    q.offer(currentNode.right);
            }
        }
    }

}

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int val) {
        this.val = val;
    }

    public void printSiblingLinks(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + "-->");
        printSiblingLinks(root.next);

    }
}
