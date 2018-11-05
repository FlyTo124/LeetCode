package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution08 {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++){
            int num = map.get(s.substring(i, i+1));
            int next = map.get(s.substring(i +1, i +2));
            if (num >= next) result += num;
            else result -=num;
        }
        result += map.get(s.substring(s.length() - 1, s.length()));
        return result;
    }

    public static void main(String[] args) {
        Solution08 s = new Solution08();
        System.out.println(s.romanToInt("LVIII"));
    }
}
