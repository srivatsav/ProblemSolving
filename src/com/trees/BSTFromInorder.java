package com.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * constructing balanced BST
 */
public class BSTFromInorder {

    public static void main(String[] args) {
        int[] inorder = { 1, 5, 7, 10, 40, 50 };
        TreeNode root = constructBST(inorder, 0, inorder.length - 1);

    }

    private static TreeNode constructBST(int[] inorder, int left, int right) {

        if (left > right)
            return null;

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(inorder[mid]);

        node.left = constructBST(inorder, left, mid - 1);
        node.right = constructBST(inorder, mid + 1, right);
        return node;
    }
}
