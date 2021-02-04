package hard;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 二叉树的序列化与反序列化
public class Solution01 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traverse(root, list);
        return list.toString();
    }

    // 前序遍历
    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(null);
            return;
        }

        list.add(node.val);
        traverse(node.left, list);
        traverse(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.isEmpty())
            return null;
        List<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(data.split(",")));
        return traverse(list);
    }

    private TreeNode traverse(List<String> list) {
        if (list.get(0) == null || list.get(0).trim().equals("null")) {
            list.remove(0);
            return null;
        }


        TreeNode root = new TreeNode(Integer.parseInt(list.get(0).trim()));
        list.remove(0);

        root.left = traverse(list);
        root.right = traverse(list);

        return root;
    }

    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        //node1.left = null;
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        String result = solution01.serialize(node1);
        TreeNode root = solution01.deserialize(result);
        System.out.println(root.val);
        System.out.println(solution01.serialize(node1));
    }
}
