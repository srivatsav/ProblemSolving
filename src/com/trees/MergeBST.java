package com.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeBST {
    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode(8);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(10);
        tree1.left.left = new TreeNode(1);

        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(3);
        tree2.left.left = new TreeNode(0);

        List<TreeNode> res = merge(tree1, tree2);

        for (TreeNode node : res)
            System.out.print(node.val + "->");

    }

    private static List<TreeNode> merge(TreeNode root1, TreeNode root2) {

        List<TreeNode> res = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode current1 = root1;
        TreeNode current2 = root2;

        if (root1 == null || root2 == null)
            return res;

        while (current1 != null) {
            stack1.push(current1);
            current1 = current1.left;
        }

        while (current2 != null) {
            stack2.push(current2);
            current2 = current2.left;
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            current1 = stack1.peek();
            current2 = stack2.peek();

            if (current1.val < current2.val) {
                current1 = stack1.pop();
                res.add(current1);

                TreeNode temp = current1.right;

                while (temp != null) {
                    stack1.push(temp);
                    temp = temp.left;
                }
            } else {
                current2 = stack2.pop();
                res.add(current2);

                TreeNode temp = current2.right;

                while (temp != null) {
                    stack2.push(temp);
                    temp = temp.left;
                }
            }

        }

        while (!stack1.isEmpty()) {
            res.add(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pop());
        }

        return res;
    }
}
