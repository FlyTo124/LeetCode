package easy;

import java.util.ArrayList;
import java.util.List;

//回文数
public class Solution02 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        List<Integer> nunms = this.getSingleNums(x);
        int length = nunms.size();
        for (int i = 0;i < length/2; i++){
            if (nunms.get(i) != nunms.get(length -1 - i)) return false;
        }
        return true;
    }

    private List<Integer> getSingleNums(int x){
        List<Integer> nums = new ArrayList<>();
        while (x > 0){
            nums.add(x%10);
            x = x/10;
        }
        return nums;
    }
}
