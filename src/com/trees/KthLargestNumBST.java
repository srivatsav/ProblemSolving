package com.trees;

public class KthLargestNumBST {

    static int res, count = 0;

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(4);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(9);

        kthlargestEle(tree1, 2);
        System.out.println(res);
    }

    private static void kthlargestEle(TreeNode root, int k) {

        if (root == null)
            return;

        kthlargestEle(root.right, k);

        if (++count == k) {
            res = root.val;
            return;
        }
        kthlargestEle(root.left, k);

    }

}
