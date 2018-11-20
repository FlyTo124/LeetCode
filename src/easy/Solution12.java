package easy;

public class Solution12 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (n > 0) n += nums[i];
            else n = nums[i];
            if (sum < n) sum = n;
        }
        return sum;
    }
}
