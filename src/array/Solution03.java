package array;

// 旋转数组
// 要求使用空间复杂度为 O(1) 的 原地 算法。
public class Solution03 {

        public void rotate(int[] nums, int k) {
            while (k > 0) {
                moveArray(nums);
                k--;
            }
        }

        private void moveArray(int[] nums) {
            int value = nums[0];
            nums[0] = nums[nums.length - 1];
            for (int i = 1; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = value;
                value = temp;
            }
        }

}
