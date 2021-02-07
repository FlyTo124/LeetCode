package medium;

// 零钱兑换 暴力解法
public class Solution17 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int re = coinChange(coins, amount - coin);
            if (re >= 0)
                res = Math.min(res, re);
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        res++;
        return res;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2, 5};
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.coinChange(coins, 12));
    }


}
