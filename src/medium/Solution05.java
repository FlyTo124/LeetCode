package medium;

import model.TreeNode;

// 二叉树展开为链表
public class Solution05 {

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        // 后续遍历
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode tempNode = root;

        while (tempNode.right != null)
            tempNode = tempNode.right;
        tempNode.right = right;
    }


}
