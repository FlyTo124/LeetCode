package easy;

import com.sun.deploy.util.StringUtils;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

//二叉树的层次遍历 II
public class Solution22 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        this.getValueByTreeNodes(nodes,result);
        return result;
    }

    private void getValueByTreeNodes(List<TreeNode> nodes, List<List<Integer>> result){
        List<Integer> values = new ArrayList<>();
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode node : nodes){
             values.add(node.val);
             if (node.left != null) children.add(node.left);
             if (node.right != null) children.add(node.right);

        }
        if (children.size() != 0) this.getValueByTreeNodes(children, result);
        result.add(values);
    }
}
