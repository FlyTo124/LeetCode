package medium;

import model.TreeNode;

// 二叉搜索树中第K小的元素
// 二叉搜索树 中序遍历是有序的
public class Solution10 {

    private int index = 0;

    private int res = 0;


    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null)
            return;
        // 中序遍历
        traverse(root.left, k);
        index++;
        if (index == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
