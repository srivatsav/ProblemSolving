package com.trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
  static int currentSum = 0;

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

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    computePaths(root, 8, res, new ArrayList<Integer>());

    for (List<Integer> list : res) {
      for (Integer i : list)
        System.out.print(i + "-->");

      System.out.println();
    }
  }

  private static void computePaths(TreeNode root, int sum, List<List<Integer>> res, List<Integer> current) {
    if (root == null)
      return;

    if (root.left == null && root.right == null) {
      currentSum += root.val;
      if (currentSum == sum) {
        current.add(root.val);
        res.add(new ArrayList<Integer>(current));
        currentSum -= root.val;
        current.remove(current.size() - 1);
      } else {
        currentSum -= root.val;
      }
      return;
    }

    currentSum += root.val; // 22
    current.add(root.val); // [5, 8, 4, 5]

    computePaths(root.left, sum, res, current);
    computePaths(root.right, sum, res, current);

    currentSum -= root.val;
    current.remove(current.size() - 1);

  }
}