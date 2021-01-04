package array;

// 买卖股票的最佳时机 II
public class Solution02 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int profit = 0;
        int buyPrice = prices[0];
        int i = 1;
        while (i < prices.length) {
            if (prices[i] > buyPrice) {
                profit = profit + prices[i] - buyPrice;
                buyPrice = prices[i];
            }
            if (prices[i] < buyPrice)
                buyPrice = prices[i];
            i++;
        }
        return profit;
    }
}
