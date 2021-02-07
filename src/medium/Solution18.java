package medium;

import java.util.HashMap;
import java.util.Map;

// 零钱兑换 备忘录
public class Solution18 {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo.get(amount) != null) return memo.get(amount);
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int re = coinChange(coins, amount - coin);
            if (re >= 0)
                res = Math.min(res, re);
        }
        if (res == Integer.MAX_VALUE)
            res = -2;
        res++;
        memo.put(amount, res);
        return res;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2, 5};
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.coinChange(coins, 12));
    }


}
