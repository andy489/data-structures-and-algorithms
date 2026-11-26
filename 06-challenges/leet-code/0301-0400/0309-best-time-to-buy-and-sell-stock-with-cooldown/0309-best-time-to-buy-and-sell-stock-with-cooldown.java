// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

// Solution: State Machine DP — O(n) time, O(1) space
class Solution {
    public int maxProfit(int[] prices) {
        int held = -prices[0], sold = 0, rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int newHeld = Math.max(held, rest - prices[i]);
            int newSold = held + prices[i];
            int newRest = Math.max(rest, sold);
            held = newHeld; sold = newSold; rest = newRest;
        }
        return Math.max(sold, rest);
    }
}
