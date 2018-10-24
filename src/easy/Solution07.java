package easy;

// 移除元素
public class Solution07 {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        while (i < length){
            if (nums[i]== val){
                length --;
                nums[i] = nums[length];
            }else i++;
        }
        return length;
    }

}
