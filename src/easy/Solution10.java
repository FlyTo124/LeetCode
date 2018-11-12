package easy;

public class Solution10 {

    public int strStr(String haystack, String needle) {
        if (needle.equals("") || haystack.equals(needle)) {
            return 0;
        }
        int index = -1;
        if (haystack.contains(needle)) {
            String[] str = haystack.split(needle);
            if (str.length >= 1) {
                index = str[0].length();
            } else {
                index = 0;
            }
        } else {
            index = -1;
        }
        return index;
    }

}
