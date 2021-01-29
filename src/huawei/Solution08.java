package huawei;

// 汽水瓶
public class Solution08 {

    public static void main(String[] args) {
        int result = 0;
        int restNum = 81;
        while (restNum >= 3) {
            int m = restNum / 3;
            result = result + m;
            restNum = restNum - m * 2;
        }
        if (restNum == 2)
            result = result + 1;
        System.out.println(result);
    }
}
