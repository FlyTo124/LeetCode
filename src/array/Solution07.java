package array;

import java.util.HashSet;
import java.util.Set;

//有效的数独
public class Solution07 {

    // 暴力法
    public boolean isValidSudoku(char[][] board) {
        int m = 0;
        for (int i = 0; i < 9; i++) {
            char[] nums = new char[]{board[0][i], board[1][i], board[2][i], board[3][i], board[4][i], board[5][i], board[6][i], board[7][i], board[8][i]};
            boolean re1 = this.isRepeat(nums);
            if (!re1) return false;
            char[] nums2 = new char[]{board[i][0], board[i][1], board[i][2], board[i][3], board[i][4], board[i][5], board[i][6], board[i][7], board[i][8]};
            boolean re2 = this.isRepeat(nums2);
            if (!re2) return false;
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                char[] nums3 = new char[]{board[i][j], board[i][j + 1], board[i][j + 2], board[i + 1][j], board[i + 1][j + 1], board[i + 1][j + 2], board[i + 2][j], board[i + 2][j + 1], board[i + 2][j + 2]};
                boolean re3 = this.isRepeat(nums3);
                if (!re3) return false;
            }
        }
        return true;
    }

    private boolean isRepeat(char[] nums) {
        int j = 0;
        Set<Integer> set = new HashSet<>();
        for (char num : nums) {
            if (num != '.') {
                j++;
                set.add((int) num);
            }
        }
        return set.size() == j;
    }

}
