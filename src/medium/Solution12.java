package medium;

import model.TreeNode;

// 删除二叉搜索树中的节点
// 左小右大
public class Solution12 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        // 1. 首先找到需要删除的节点
        // 找到了 开始删除
        if (root.val == key) {
            // 如果该节点 为叶子节点，直接删除
            // 下面两个if 可以包含这种情况
            //            if (root.left == null && root.right == null)
            //                return null;
            // 如果只有左孩子
            if (root.right == null)
                return root.left;
            if (root.left == null)
                return root.right;
            // 如果左右孩子都有，则需要找到左子树的最大节点 或者 右子树的最小节点来替换该节点
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        // 没找到
        // 如果节点值比key大 从左边找
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }


}
