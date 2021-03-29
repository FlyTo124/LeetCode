package medium;

import java.util.LinkedList;
import java.util.List;

// 字符串的排列
public class Solution25 {

    List<List<Character>> res = new LinkedList<>();

    public String[] permutation(String s) {
        char[] chs = s.toCharArray();
        LinkedList<Character> track = new LinkedList<>();
        backtrack(chs, track);
        String[] strings = new String[res.size()];
        for (int i = 0; i < strings.length; i++) {
            List<Character> characterList = res.get(i);
            StringBuilder sb = new StringBuilder();
            for (Character c : characterList)
                sb.append(c);
            strings[i] = sb.toString();
        }
        return strings;
    }

    private void backtrack(char[] chs, LinkedList<Character> track) {
        if (track.size() == chs.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < chs.length; i++) {
            if (track.contains(chs[i]))
                continue;
            track.add(chs[i]);
            backtrack(chs, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution25 s = new Solution25();
        String[] res = s.permutation("aab");
        for (String str : res)
            System.out.println(str);
    }
}
