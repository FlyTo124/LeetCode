package easy;

// 两数之和
public class Solution01 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int firstIndex = 0;
        int secondIndex = 1;
        while (!isRightNums(nums[firstIndex], nums[secondIndex], target)){
            if (secondIndex < length) secondIndex ++;
            if (secondIndex == length){
                firstIndex ++;
                secondIndex = firstIndex + 1;
            }
            if (firstIndex == (length -1)) return null;
        }
        return new int[]{firstIndex, secondIndex};
    }

    private boolean isRightNums(int num1, int num2, int target){
        return num1 + num2 == target;
    }
}
