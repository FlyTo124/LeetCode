package easy;


import model.TreeNode;

//平衡二叉树
public class Solution24 {

//    public boolean isBalanced(TreeNode root) {
//
//        if (root == null) return true;
//        int maxHeight = 1;
//        int minHeight = 1;
//        int size = 1;
//        List<TreeNode> children = this.getChildren(Arrays.asList(root));
//        while (children.size() > 0) {
//            maxHeight++;
//            if (children.size() == size * 2) {
//                minHeight++;
//                size = children.size();
//            }
//            children = this.getChildren(children);
//        }
//        return maxHeight - minHeight <= 1 ? true : false;
//    }
//
//    private List<TreeNode> getChildren(List<TreeNode> treeNodes) {
//        List<TreeNode> children = new ArrayList<>();
//        for (TreeNode treeNode : treeNodes) {
//            if (treeNode.left != null) children.add(treeNode.left);
//            if (treeNode.right != null) children.add(treeNode.right);
//        }
//        return children;
//    }

    public boolean isBalanced(TreeNode root) {
        int leftHeight = 1;
        int rightHeight = 1;
        return false;
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        node4.left = node6;
        node4.right = node7;
        node2.left = node4;
        node2.right = node3;
        node1.left = node2;
        node1.right = node3;
        Solution24 s = new Solution24();
        System.out.println(s.isBalanced(node1));
    }


}
