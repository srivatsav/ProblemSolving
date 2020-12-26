package com.trees;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree
 * (BST), where largest means subtree with largest number of nodes in it.
 */
public class LargestBST {

    private int maxSize = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(9);

        LargestBST largestBST = new LargestBST();
        System.out.println(largestBST.largestBSTSubtree(root));
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        largestBSTHelper(root);
        return maxSize;
    }

    private Data largestBSTHelper(TreeNode root) {
        Data curr = new Data();
        if (root == null) {
            curr.isBST = true;
            return curr;
        }

        Data left = largestBSTHelper(root.left);
        Data right = largestBSTHelper(root.right);

        curr.minVal = Math.min(root.val, Math.min(left.minVal, right.minVal));
        curr.maxVal = Math.max(root.val, Math.max(left.maxVal, right.maxVal));

        if (left.isBST && root.val > left.maxVal && right.isBST && root.val < right.minVal) {
            curr.size = left.size + right.size + 1;
            curr.isBST = true;
            maxSize = Math.max(maxSize, curr.size);
        } else {
            curr.size = 0;
        }

        return curr;
    }

    class Data {
        int size = 0;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        boolean isBST = false;
    }
}
