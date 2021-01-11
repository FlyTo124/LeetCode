package string;

import java.util.Arrays;

// 有效的字母异位词
public class Solution03 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] charss = s.toCharArray();
        Arrays.sort(charss);
        char[] charst = t.toCharArray();
        Arrays.sort(charst);
        for (int i = 0; i < s.length(); i++) {
            if (charss[i] != charst[i])
                return false;
        }
        return true;
    }

}
