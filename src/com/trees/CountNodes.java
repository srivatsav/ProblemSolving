package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(4);
    TreeNode node4 = new TreeNode(5);
    TreeNode node5 = new TreeNode(6);

    root.left = node1;
    root.right = node2;
    node1.left = node3;
    node1.right = node4;
    node2.left = node5;

    System.out.println(countNodes(root));
  }

  public static int countNodes(TreeNode root) {
    if (root == null)
      return 0;

    Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    Queue<TreeNode> q2 = new LinkedList<TreeNode>();

    q1.add(root);

    int count = 0;

    while (!q1.isEmpty() || !q2.isEmpty()) {
      int q1Size = q1.size(); // 3
      int q2Size = q2.size(); // 0

      count += q1Size + q2Size; // 6

      if (q1Size > 0) {
        while (!q1.isEmpty()) {
          TreeNode temp = q1.poll();
          if (temp.left != null)
            q2.add(temp.left);
          if (temp.right != null)
            q2.add(temp.right);
        }
      } else if (q2Size > 0) {
        while (!q2.isEmpty()) {
          TreeNode temp = q2.poll();
          if (temp.left != null)
            q1.add(temp.left);
          if (temp.right != null)
            q1.add(temp.right);
        }
      }

    }

    return count;
  }

}