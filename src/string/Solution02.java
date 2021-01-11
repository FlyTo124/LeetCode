package string;

import java.util.LinkedHashMap;
import java.util.Map;

// 字符串中的第一个唯一字符
public class Solution02 {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (null == map.get(chars[i])) {
                map.put(chars[i], i);
            } else {
                map.put(chars[i], chars.length);
            }
        }
        for (Integer index : map.values()) {
            if (index < chars.length)
                return index;
        }
        return -1;
    }

}
