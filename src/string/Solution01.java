package string;

// 反转字符串
public class Solution01 {

    public void reverseString(char[] s) {
        int length = s.length;
        int loopLength = (int) Math.floor(length >> 1);
        for (int i = 0; i < loopLength; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }

}
