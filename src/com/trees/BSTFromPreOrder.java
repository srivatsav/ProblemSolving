package com.trees;

public class BSTFromPreOrder {

    static int idx = 0;

    public static void main(String[] args) {
        int[] preorder = { 10, 5, 1, 7, 40, 50 };
        TreeNode root = constructBST(preorder, Integer.MAX_VALUE);
    }

    private static TreeNode constructBST(int[] preorder, int value) {

        if (idx >= preorder.length || preorder[idx] > value)
            return null;

        TreeNode root = new TreeNode(preorder[idx++]);

        root.left = constructBST(preorder, root.val);
        root.right = constructBST(preorder, value);

        return root;
    }

}
