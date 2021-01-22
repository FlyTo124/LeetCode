package medium;


// 最长回文子串
public class Solution02 {

    public String longestPalindrome(String s) {
        int length = s.length(),
                maxlength = 1,
                startIndex = 0;
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
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxlength);
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.longestPalindrome("a"));
    }
}
