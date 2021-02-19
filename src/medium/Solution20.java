package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 子集
public class Solution20 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, 0);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, int start) {
        res.add(track);
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, track, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        int[] nums = new int[]{1, 2};
        List<List<Integer>> res = solution20.subsets(nums);
        System.out.println(res.size());
    }
}
