package array;

import java.util.Arrays;

// 存在重复元素
public class Solution04 {


    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
