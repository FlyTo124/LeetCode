package huawei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 合唱队
public class Solution11 {

    List<List<Integer>> res = new LinkedList<>();

    private List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    // 判断是否是合唱队
    private boolean isValid(List<Integer> list) {
        if (list.size() == 0) return false;
        boolean flag = true;
        for (int i : list) {

        }
        return flag;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] height = new int[n];
        int i = 0;
        while (in.hasNextInt()) {
            height[i] = in.nextInt();
            i++;
        }
        System.out.println("一共有多少个人:" + n);
        System.out.println("高度分别为:");
        for (int he : height)
            System.out.print(" " + he + ",");
        in.close();
    }
}
