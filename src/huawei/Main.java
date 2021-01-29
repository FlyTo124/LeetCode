package huawei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        while (in.hasNext()) {
            int num = in.nextInt();
            if (num == 0)
                break;
            System.out.println(main.getResult(num));
        }
        in.close();
    }

    private int getResult(int num) {
        int result = 0;
        int restNum = num;
        while (restNum >= 3) {
            int m = restNum / 3;
            result = result + m;
            restNum = restNum - m * 2;
        }
        if (restNum == 2)
            result = result + 1;
        return result;
    }
}
