package array;

import java.util.Arrays;


// 只出现一次的数字
public class Solution05 {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1])
                return nums[i];
            else
                i += 2;
        }
        return 0;
    }
}
