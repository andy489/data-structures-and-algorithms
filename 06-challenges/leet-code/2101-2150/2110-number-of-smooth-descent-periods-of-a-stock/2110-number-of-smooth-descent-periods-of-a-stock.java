// https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/

// Solution: Running Count — O(n) time, O(1) space
class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 0;
        int run = 1;

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] == prices[i - 1] - 1) {
                run++;
            } else {
                run = 1;
            }
            result += run;
        }

        return result;
    }
}
