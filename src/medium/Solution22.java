package medium;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.List;

// 全排列
public class Solution22 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backTrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        int[] nums = new int[]{1, 2, 3};
        solution22.permuteUnique(nums);
    }
}
