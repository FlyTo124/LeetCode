package huawei;

import java.util.Scanner;
// 对字符串中的所有单词进行倒排。
public class Solution01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split("[^a-zA-Z]");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--)
            sb.append(sp[i] + " ");
        System.out.println(sb.toString().trim());
        sc.close();
    }
}
