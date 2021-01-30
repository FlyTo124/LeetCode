package huawei;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// 删除字符串中出现次数最少的字符
public class Solution09 {

    public static void main(String[] args) {
        String str = "aabcddd";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }
        StringBuilder sb = new StringBuilder();
        int min = map.values().stream().findFirst().get();
        for (int nu : map.values()) {
            min = Math.min(min, nu);
        }
        int minNum = min;
        List<Character> deleteList = new ArrayList<>();
        map.forEach((k, v) -> {
                    if (v == minNum)
                        deleteList.add(k);
                }
        );
        for (char ch : str.toCharArray()) {
            if (!deleteList.contains(ch))
                sb.append(ch);
        }

        System.out.println(sb.toString());
    }
}
