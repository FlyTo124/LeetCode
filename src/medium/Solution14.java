package medium;

import model.TreeNode;

// 验证二叉搜索树
public class Solution14 {

    public boolean isValidBST(TreeNode root) {
        // 这样写并不能保证 root节点大于所有左子树 小于所有右子树
//        if (root == null)
//            return true;
//        if (root.left != null && root.val <= root.left.val)
//            return false;
//        if (root.right != null && root.val >= root.right.val)
//            return false;
//        return isValidBST(root.left) && isValidBST(root.right);
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null)
            return true;
        if (min != null && node.val <= min.val)
            return false;
        if (max != null && node.val >= max.val)
            return false;
        return isValidBST(node.right, node, max) && isValidBST(node.left, min, node);
    }
}
