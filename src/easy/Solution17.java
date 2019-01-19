package easy;

public class Solution17 {

    public int climbStairs(int n) {
        int result = 0;
        //2的个数
        int m = 0;
        // 总的步数
        int total = n;
        while (m <= total) {
            result += this.calculateCombination(total, total - m);
            total--;
            m++;
        }
        return result;
    }

    //计算阶乘
    public int calculateArrangement(int num) {
        int result = 1;
        while (num > 0) {
            result = result * num;
            num--;
        }
        return result;
    }

    //计算组合
    //TODO 计算超过int最大值
    public int calculateCombination(int num1, int num2) {
        return 1;
    }

    public static void main(String[] args) {
        Solution17 s = new Solution17();
        System.out.println(s.climbStairs(38));
    }
}
