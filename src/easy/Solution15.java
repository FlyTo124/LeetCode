package easy;


import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// TODO 太慢了
public class Solution15 {

    public int maxDepth(TreeNode root) {
        if (root != null){
            List<TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(root);
            return this.isLeaf(treeNodes , 1);
        }
        return 0;
    }

    private int isLeaf(List<TreeNode> nodes, int maxDepth){
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TreeNode node : nodes){
            if (node.right != null)
                treeNodes.add(node.right);
            if (node.left != null)
                treeNodes.add(node.left);
        }
        boolean isLeaf = treeNodes.size() == 0 ? true : false;
        if (!isLeaf)
            maxDepth = this.isLeaf(treeNodes, maxDepth) + 1;
        return maxDepth;
    }
}
