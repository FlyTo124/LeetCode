package medium;

import model.TreeNode;

// 1038. 把二叉搜索树转换为累加树
public class Solution11 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;

        // 中序遍历 逆序输出
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
