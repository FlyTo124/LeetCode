package easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution20 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p != null && q == null) || (p == null && q != null)) return false;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(p.val);
        list2.add(q.val);
        this.getTreeNodeValue(p, list1);
        this.getTreeNodeValue(q, list2);
        boolean flag = list1.size() == list2.size();
        if (flag) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) == null && list2.get(i) == null)
                    continue;
                if (jugeCondition(list1, list2, i)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private boolean jugeCondition(List<Integer> list1, List<Integer> list2, int i) {
        return (list1.get(i) == null && list2.get(i) != null) || (list1.get(i) != null && list2.get(i) == null)
                || (!list1.get(i).equals(list2.get(i)));
    }

    private void getTreeNodeValue(TreeNode treeNode, List<Integer> list) {
        if (treeNode.left != null || treeNode.right != null) {
            if (treeNode.left != null) {
                list.add(treeNode.left.val);
                this.getTreeNodeValue(treeNode.left, list);
            } else {
                list.add(null);
            }
            if (treeNode.right != null) {
                list.add(treeNode.right.val);
                this.getTreeNodeValue(treeNode.right, list);
            } else {
                list.add(null);
            }

        }
    }

}
