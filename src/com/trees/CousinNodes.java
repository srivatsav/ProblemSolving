package com.trees;

public class CousinNodes {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(4);
    TreeNode node4 = new TreeNode(5);
    TreeNode node5 = new TreeNode(6);
    TreeNode node6 = new TreeNode(7);

    root.left = node1;
    root.right = node2;
    node1.left = node3;
    node1.right = node4;
    node2.left = node5;
    node2.right = node6;

    System.out.print(" Are the given nodes cousins :: " + checkIfCousins(root, 4, 6));
  }

  static boolean checkIfCousins(TreeNode root, int n1, int n2) {
    Pair pair1 = findLevel(root, n1, null, 0);
    Pair pair2 = findLevel(root, n2, null, 0);
    return pair1.level == pair2.level && pair1.node != pair2.node;
  }

  static Pair findLevel(TreeNode root, int val, TreeNode parent, int level) {
    if (root == null) return null;

    if (root.val == val) return new Pair(parent, level);

    Pair leftPair = findLevel(root.left, val, root, level + 1);
    Pair rightPair = findLevel(root.right, val, root, level + 1);
    return leftPair != null ? leftPair : rightPair;
  }

  static class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }
}
