package easy;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//有效的括号
public class Solution06 {

    public boolean isValid(String s) {
        if (s.equals("")) return true;
        if (s.length() % 2 == 1) return false;
        List<String> list = new LinkedList<>();
        Map<String, String> map = new HashMap<>();
        map.put("{", "}");
        map.put("(", ")");
        map.put("[", "]");
        for (int i = 0; i < s.length(); i++) {
            String n = s.substring(i, i + 1);
            if (map.containsKey(n)) list.add(n);
            else {
                if (list.size() == 0) return false;
                if (!map.get(list.get(list.size() - 1)).equals(n)) return false;
                list.remove(list.size() - 1);
            }
        }
         return list.size() == 0 ? true : false;
    }
}
