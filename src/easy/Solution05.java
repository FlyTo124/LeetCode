package easy;

// 最长公共前缀
public class Solution05 {

    public String longestCommonPrefix(String[] strs) {
        int arrayLenth = strs.length;
        String result = "";
        if(arrayLenth == 0) return "";
        else if (arrayLenth == 1) return strs[0];
        else {
            int minLength = this.getMinLength(strs);
            for (int i = 0; i < minLength; i++){
                for (int j = 0; j < arrayLenth - 1; j++) {
                    if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                        System.out.println(i);
                        System.out.println(j);
                        return result;
                    }
                }
                result = strs[0].substring(0, i+1);
            }
        }
        return result;
    }

    private int getMinLength(String[] strs){
        String min = strs[0];
        for (int i =1; i < strs.length; i++){
            if (min.length() > strs[i].length()) min = strs[i];
        }
        return min.length();
    }

}
