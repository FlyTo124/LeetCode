package huawei;

import java.util.Scanner;

public class Solution02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution02 main = new Solution02();
        System.out.println(main.longestPalindrome(s));
        sc.close();
    }

    public int longestPalindrome(String s) {
        int length = s.length(),
                maxlength = 1;
        boolean[][] container = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            container[i][i] = true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j))
                    container[i][j] = false;
                else {
                    if ((j - i) < 3)
                        container[i][j] = true;
                    else {
                        container[i][j] = container[i + 1][j - 1];
                    }
                }
                if (container[i][j] && maxlength < (j - i + 1)) {
                    maxlength = j - i + 1;
                }
            }
        }
        return maxlength;
    }

}

