package com.milley.binarytreepath;

import com.milley.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        if (root != null) {
            iterateChild(root, "", pathList);
        }
        return pathList;
    }

    private void iterateChild(TreeNode root, String path, List<String> pathList) {
        if (root.left != null) {
            iterateChild(root.left, path + root.val + "->", pathList);
        }
        if (root.right != null) {
            iterateChild(root.right, path + root.val + "->", pathList);
        }
        if (root.left == null && root.right == null) {
            pathList.add(path + root.val);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node2.right = node5;
        node3.left = node4;
        node3.right = node6;

        List<String> paths = new Solution().binaryTreePaths(root);
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
