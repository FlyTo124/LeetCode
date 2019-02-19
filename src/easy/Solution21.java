package easy;

import model.TreeNode;

import java.util.*;

public class Solution21 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null)
            return true;
        if ((root.left != null && root.right == null) || (root.right != null && root.left == null))
            return false;
        if (root.left.val != root.right.val)
            return false;
        List<TreeNode> parentTreeNodes1 = new ArrayList<>();
        List<TreeNode> parentTreeNodes2 = new ArrayList<>();
        parentTreeNodes1.add(root.left);
        parentTreeNodes2.add(root.right);
        boolean flag = true;
        while (flag && (parentTreeNodes1.size() != 0 || parentTreeNodes2.size() != 0)) {
            parentTreeNodes1 = this.getLastLevelTreeNodes(parentTreeNodes1);
            parentTreeNodes2 = this.getLastLevelTreeNodes(parentTreeNodes2);
            if (parentTreeNodes1 == null || parentTreeNodes2 == null) {
                break;
            }
            List<Integer> list1 = this.getTreeNodesValue(parentTreeNodes1);
            List<Integer> list2 = this.getTreeNodesValue(parentTreeNodes2);
            flag = list1.size() == list2.size();
            if (flag) {
                for (int i = 0; i < list1.size(); i++) {
                    if (list1.get(i) == null && list2.get(list1.size() - 1 - i) == null)
                        continue;
                    if (list1.get(i) == null || list2.get(list1.size() - 1 - i) == null || list1.get(i) != list2.get(list1.size() - 1 - i)) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;

    }


    private List<TreeNode> getLastLevelTreeNodes(List<TreeNode> parentTreeNodes) {
        boolean flag = false;
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode parentTreeNode : parentTreeNodes) {
            if (parentTreeNode == null) continue;
            if (parentTreeNode.left != null || parentTreeNode.right != null)
                flag = true;
            children.add(parentTreeNode.left == null ? null : parentTreeNode.left);
            children.add(parentTreeNode.right == null ? null : parentTreeNode.right);
        }

        if (!flag) return null;
        return children;
    }

    private List<Integer> getTreeNodesValue(List<TreeNode> treeNodes) {
        List<Integer> list = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            list.add(treeNode == null ? null : treeNode.val);
        }
        return list;
    }


    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Solution21 s = new Solution21();
        String input = "[2,3,3,4,5,5,4,null,null,8,9,null,null,9,8]";
        TreeNode treeNode = Solution21.stringToTreeNode(input);
        System.out.println(s.isSymmetric(treeNode));
    }


}
