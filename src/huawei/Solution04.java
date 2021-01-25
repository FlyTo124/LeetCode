package huawei;

import java.util.Scanner;

public class Solution04 {

    public int A;

    public int B;

    public int C;

    public int D;

    public int E;

    // 错误IP地址或错误掩码
    public int F;

    // 私有IP的个数
    public int G;

    public void getResult() {
        System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G);
    }

    private boolean isLegalPattern(String str) {
        String[] strings = str.split(".");
        for (String s : strings) {
            if (!isInteger(str))
                return false;
            if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0)
                return false;
        }
        return true;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private int getCharCount(char cha, String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == cha)
                count++;
        }
        return count;
    }

    private boolean checkValue(String ip) {
        int count = getCharCount('.', ip);
        if (count != 3) {
            F++;
            return false;
        }
        String[] strings = ip.split("\\.");
        for (String s : strings) {
            if (!isInteger(s)) {
                F++;
                return false;
            } else if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) {
                F++;
                return false;
            }
        }
        return true;
    }

    public void setValue(String ip) {
        boolean flag = this.checkValue(ip);
        if (!flag)
            return;
        String[] strings = ip.split("\\.");
        int first = Integer.parseInt(strings[0]);
        int second = Integer.parseInt(strings[1]);
        if (first > 0 && first <= 126) {
            if (first == 10)
                G++;
            else
                A++;
        } else if (first > 127 && first <= 191) {
            if (first == 172 && second >= 16 && second <= 31)
                G++;
            else
                B++;
        } else if (first > 191 && first <= 223) {
            if (first == 192 && second == 168)
                G++;
            else
                C++;
        } else if (first > 223 && first < 239)
            D++;
        else if (first > 239 && first <= 255)
            E++;
    }

    public void setMask(String mask) {

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        while (in.hasNextLine()) {
            String str = in.nextLine();
            if (str.isEmpty())
                break;
            String[] strings = str.split("~");
            String ip = strings[0];
            String mask = strings[1];
            main.setValue(ip);
        }
        main.getResult();
    }
}

