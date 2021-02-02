package medium;


import model.TreeNode;

// 从前序与中序遍历序列构造二叉树
public class Solution07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        int root = preorder[preStart];

        TreeNode rootNode = new TreeNode(root);

        int rootIndex = -1;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart;
        rootNode.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex - 1);
        rootNode.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return rootNode;
    }

}
