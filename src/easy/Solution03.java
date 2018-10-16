package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//罗马数字转整数
public class Solution03 {
    public int romanToInt(String s) {
        Map<String,Integer> map = this.setRules();
        int num = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            result.add(map.get(s.substring(i,i+1)));
        }
        for (int j = 0; j < result.size(); j++){
            if (j == result.size() -1) num += result.get(j);
            else if (result.get(j) >= result.get(j + 1)) num += result.get(j);
            else num -= result.get(j);
        }
        return num;
    }

    private Map<String,Integer> setRules(){
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        return map;
    }
}
