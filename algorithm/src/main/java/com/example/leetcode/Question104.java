package com.example.leetcode;

import com.example.leetcode.common.TreeNode;
import com.example.utils.LogUtil;

/**
 * Created by louyuting on 16/11/20.
 * 求二叉树的最大深度
 * 104. Maximum Depth of Binary Tree
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Question104 {

    /**
     * 用递归做.
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())); //isLeaf is checked here
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(2));

        TreeNode left1 = root.getLeft();
        left1.setLeft(new TreeNode(3));

        LogUtil.log_debug("" + maxDepth(root));

    }
}
