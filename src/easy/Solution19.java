package easy;

public class Solution19 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
           for (int i = 0; i < n; i++){
               nums1[i] = nums2[i];
           }
        } else if (n != 0){
            int index = 0;
            int j = 0;
            while (j < n && index < nums1.length){
                if (nums1[index] <= nums2[j] && index < m){
                    index++;
                } else {
                    this.insertNumToArray(nums1, nums2[j], index);
                    index++;
                    j++;
                    m++;
                }
            }
        }
        for (int v : nums1){
            System.out.println(v);
        }
    }


    public void insertNumToArray(int[] nums, int num, int index){
        int j = index;
        int x = num;
        for (int i = j; i < nums.length; i++){
//            if (nums[j] == 0 && x == 0){
//                break;
//            }
            int z = nums[j];
            nums[j] = x;
            x = z;
            j++;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,0,3,0,0,0,0};
        int[] nums2 = new int[]{1,2};
        Solution19 s = new Solution19();
        s.merge(nums1, 3, nums2, 2);
    }
}
