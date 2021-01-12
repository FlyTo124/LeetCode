package string;

// 字符串转换整数 (atoi)
public class Solution05 {

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (' ' == aChar && !flag)
                continue;
            flag = true;
            if ('+' == aChar && sb.length() == 0 && i != chars.length - 1 && Character.isDigit(chars[i + 1]))
                continue;
            if ('-' == aChar && sb.length() == 0 && i != chars.length - 1 && Character.isDigit(chars[i + 1]))
                sb.append(aChar);
            else if (Character.isDigit(aChar))
                sb.append(aChar);
            else
                break;
        }
        String result = sb.toString();
        if (sb.length() == 0 || result.equals("-"))
            return 0;
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            if (result.charAt(0) == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
    }

}
