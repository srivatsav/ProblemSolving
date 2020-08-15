package com.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class VerticalOrderTraversal {
  static List<List<Integer>> res;
  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(9);
    TreeNode node2 = new TreeNode(20);
    TreeNode node3 = new TreeNode(15);
    TreeNode node4 = new TreeNode(7);

    root.left = node1;
    root.right = node2;
    node2.left = node3;
    node2.right = node4;

    verticalTraversal(root);

    for (List<Integer> entry : res) {
      for (Integer n : entry)
        System.out.print(n + "-->");
      System.out.println();
    }
  }

  private static List<List<Integer>> verticalTraversal(TreeNode root) {

    res = new ArrayList<List<Integer>>();

    if (root == null)
      return res;

    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    verticalTraversal(root, 0, map);

    for (int i = min; i <= max; i++) {
      if (map.get(i) != null) {
        List<Integer> temp = new ArrayList<Integer>(map.get(i));
        res.add(temp);
      }
    }
    return res;
  }

  private static void verticalTraversal(TreeNode root, int idx, Map<Integer, Set<Integer>> map) {
    min = Math.min(idx, min);
    max = Math.max(idx, max);

    if (map.get(idx) == null) {
      Set<Integer> temp = new TreeSet<Integer>();
      temp.add(root.val);
      map.put(idx, temp);
    } else {
      map.get(idx).add(root.val);
    }

    if (root.left != null)
      verticalTraversal(root.left, idx - 1, map);
    if (root.right != null)
      verticalTraversal(root.right, idx + 1, map);
  }
}