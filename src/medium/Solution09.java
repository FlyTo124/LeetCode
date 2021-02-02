package medium;

import model.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution09 {

    Map<String, Integer> map = new HashMap<>();

    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null)
            return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);

        String str = left + "," + right + "," + root.val;
        if (map.get(str) == null)
            map.put(str, 1);
        else {
            int num = map.get(str);
            if (num == 1)
                res.add(root);
            map.put(str, ++num);
        }
        return str;
    }

}
