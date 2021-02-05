package medium;

import model.TreeNode;

public class Solution15 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p == root || q == root)
            return root;
        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);

        if (root.left != null && root.right != null)
            return root;
        if (root.left == null && root.right == null)
            return null;

        return root.left == null ? root.right : root.left;
    }
}
