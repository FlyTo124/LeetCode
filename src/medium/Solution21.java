package medium;

import java.util.LinkedList;
import java.util.List;

public class Solution21 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track, k, 0);
        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> track, int k, int start) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backTrack(nums, track, k, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        solution21.combine(4, 2);
    }
}
