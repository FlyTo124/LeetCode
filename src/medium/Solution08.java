package medium;

import model.TreeNode;

// 从中序与后序遍历序列构造二叉树
public class Solution08 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        int rootVal = postorder[postEnd];
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int rightLength = inEnd - rootIndex;
        TreeNode root = new TreeNode(rootVal);

        root.left = build(postorder, postStart, postEnd - rightLength - 1,
                inorder, inStart, rootIndex - 1);
        root.right = build(postorder, postEnd - rightLength, postEnd - 1,
                inorder, rootIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        Solution08 solution08 = new Solution08();
        TreeNode node = solution08.buildTree(inorder, postorder);
        System.out.println(node.val);
    }

}
