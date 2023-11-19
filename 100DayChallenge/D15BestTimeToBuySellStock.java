// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int buyPrice = prices[0];
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] <= buyPrice) {
                buyPrice = prices[i];
                continue;
            }
            maxProfit = Math.max(maxProfit, prices[i]-buyPrice);
        }
        System.gc();
        return maxProfit;
    }
}