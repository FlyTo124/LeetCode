package array;


// 移动零
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
public class Solution06 {

    public void moveZeroes(int[] nums) {
        int firstIndex = 0;
        int lastIndex = nums.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            if (nums[i] == 0) {
                leftMove(nums, i, lastIndex);
                nums[lastIndex] = 0;
                lastIndex--;
                i = -1;
            }
            if (i == lastIndex)
                break;
        }
    }

    private void leftMove(int[] nums, int firstIndex, int lastIndex) {
        while (firstIndex < lastIndex) {
            nums[firstIndex] = nums[firstIndex + 1];
            firstIndex++;
        }
    }

    public static void main(String[] args) {
        Solution06 solution06 = new Solution06();
        int[] nums = new int[]{0, 0, 1};
        solution06.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
