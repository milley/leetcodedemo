package com.milley.invertbinarytree;

import com.milley.common.TreeNode;

/**
 * @author milley
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftChild = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(leftChild);

        return root;
    }
}
