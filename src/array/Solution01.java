package array;


// 删除排序数组中的重复项
// 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
public class Solution01 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int currentNum = nums[0];
        int length = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == currentNum) {
                i++;
            } else {
                nums[length] = nums[i];
                currentNum = nums[i];
                length++;
            }
        }
        return length;
    }

}
