package easy;

public class Solution11 {

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] < target) index++;
            if (nums[i] == target) return i;
        }
        return index;

    }

}
