package com.milley.symmetrictree;

import com.milley.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compareMirrorTree(root, root);
    }

    public boolean isSymmetricByIterate(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    private boolean compareMirrorTree(TreeNode sourceTree, TreeNode destTree) {
        if (sourceTree == null && destTree == null) {
            return true;
        }
        if (sourceTree == null || destTree == null) {
            return false;
        }
        return (sourceTree.val == destTree.val) && compareMirrorTree(sourceTree.left, destTree.right)
                && compareMirrorTree(sourceTree.right, destTree.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root21 = new TreeNode(2);
        TreeNode root22 = new TreeNode(2);
        TreeNode root31 = new TreeNode(3);
        TreeNode root32 = new TreeNode(3);
        TreeNode root41 = new TreeNode(4);
        TreeNode root42 = new TreeNode(4);

        root21.left = root31;
        root21.right = root41;

        root22.left = root42;
        root22.right = root32;

        root.left = root21;
        root.right = root22;

        System.out.println(new Solution().isSymmetric(root));
        System.out.println(new Solution().isSymmetricByIterate(root));
    }
}
