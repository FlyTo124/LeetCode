package medium;

import model.TreeNode;

// 最大二叉树
public class Solution06 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        int max = -1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        int[] leftArray = build(nums, 0, index);
        int[] rightArray = build(nums, index + 1, nums.length);
        root.left = constructMaximumBinaryTree(leftArray);
        root.right = constructMaximumBinaryTree(rightArray);
        return root;
    }

    private int[] build(int nums[], int start, int end) {
        int[] array = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            array[i] = nums[start + i];
        }
        return array;
    }


}
