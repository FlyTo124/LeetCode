package huawei;

import java.util.Locale;

// 简单密码
public class Solution07 {

    private int getNumByLowerLetter(char c) {
        String ch = String.valueOf(c);
        if ("abc".contains(ch))
            return 2;
        else if ("def".contains(ch))
            return 3;
        else if ("ghi".contains(ch))
            return 4;
        else if ("jkl".contains(ch))
            return 5;
        else if ("mno".contains(ch))
            return 6;
        else if ("pqrs".contains(ch))
            return 7;
        else if ("tuv".contains(ch))
            return 8;
        else if ("wxyz".contains(ch))
            return 9;
        else
            throw new RuntimeException();
    }

    private char getLowerByUpperLetter(char ch){
        if (ch == 'Z')
            return 'a';
        else {
            int i = ch + 1;
            return (char)i;
        }
    }

    public static void main(String[] args) {
        String test = "YUANzhi1987";
        StringBuilder sb = new StringBuilder();
        Solution07 solution07 = new Solution07();
        char[] chars  = test.toCharArray();
        for (char ch : chars){
            if (Character.isLowerCase(ch))
                sb.append(solution07.getNumByLowerLetter(ch));
            else if (Character.isUpperCase(ch))
                sb.append(solution07.getLowerByUpperLetter(ch));
            else
                sb.append(ch);
        }
        System.out.println(sb.toString().toLowerCase(Locale.ROOT));
    }
}
