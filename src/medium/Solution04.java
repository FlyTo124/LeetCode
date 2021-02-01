package medium;

import model.Node;

// 填充每个节点的下一个右侧节点指针
public class Solution04 {

    public Node connect(Node root) {
        if (root == null || root.left == null)
            return root;
        connectTwo(root.left, root.right);
        return root;
    }

    private void connectTwo(Node node1, Node node2) {
        if (node1 == null || node2 == null)
            return;
        node1.next = node2;

        connectTwo(node1.left, node1.right);
        connectTwo(node1.right, node2.left);
        connectTwo(node2.left, node2.right);
    }
}
