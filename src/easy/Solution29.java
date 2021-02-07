package easy;

// 斐波那契数
public class Solution29 {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int index = 2;
        int pre = 1;
        int prepre = 0;
        int res = 0;
        while (index <= n) {
            res = pre + prepre;
            prepre = pre;
            pre = res;
            index++;
        }
        return res;
    }
}
