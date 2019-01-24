package easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
    public int calculateCombination(int num1, int num2) {
        int result = 1;
        int num3 = num1 - num2;
        int length = num3 > num2 ? num2 : num3;
        List<Integer> list = new LinkedList<>();
        while (length > 0) {
            result *= num1;
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()){
                int x = it.next();
                if (result % x == 0){
                    result /= x;
                    it.remove();
                }
            }
            if (result % length == 0) {
                result /= length;
            }else {
               list.add(length);
            }
            num1--;
            length--;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution17 s = new Solution17();
        System.out.println(s.climbStairs(38));
    }
}
