// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

// Solution: DP with two states — O(n) time, O(1) space
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0], free = 0;
        for (int i = 1; i < prices.length; i++) {
            int newHold = Math.max(hold, free - prices[i]);
            int newFree = Math.max(free, hold + prices[i] - fee);
            hold = newHold;
            free = newFree;
        }
        return free;
    }
}
