package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution06 {

    public boolean checkLength(String s) {
        return s.length() > 8;
    }

    public boolean checkChildren(String s) {
        List<String> children = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i++) {
            String str = s.substring(i, i + 3);
            if (children.contains(str))
                return false;
            children.add(str);
        }
        return true;
    }

    public boolean checkFormat(String s) {
        boolean isUpper = false;
        boolean isLower = false;
        boolean isNumber = false;
        boolean isOther = false;
        char[] chars = s.toCharArray();
        for (char cha : chars) {
            if (Character.isDigit(cha)) {
                isNumber = true;
            } else if (Character.isLowerCase(cha)) {
                isLower = true;
            } else if (Character.isUpperCase(cha)) {
                isUpper = true;
            } else {
                isOther = true;
            }
        }
        int count = 0;
        if (isNumber)
            count++;
        if (isLower)
            count++;
        if (isUpper)
            count++;
        if (isOther)
            count++;
        return count >= 3;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution06 main = new Solution06();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            if (s.isEmpty())
                break;
            if (main.checkLength(s) && main.checkFormat(s) && main.checkChildren(s))
                System.out.println("OK");
            else
                System.out.println("NG");
        }
        in.close();
    }
}