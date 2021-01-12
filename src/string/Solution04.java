package string;

import java.util.ArrayList;
import java.util.List;

// 验证回文串
public class Solution04 {

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i <s.length() ; i++) {
           if (Character.isLetterOrDigit(chars[i]))
               list.add(chars[i]);
        }
        int index = (int) Math.floor(list.size() >> 1);
        for (int i = 0; i < index; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 -i)))
                return false;
        }
        return true;
    }


}
