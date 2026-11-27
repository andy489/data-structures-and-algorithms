// https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/

// Solution: Simulation — O(n) time, O(1) space
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waiting = 0, maxProfit = 0, bestRound = -1, rotation = 0;
        int profit = 0;
        for (int i = 0; i < customers.length || waiting > 0; i++) {
            if (i < customers.length) {
                waiting += customers[i];
            }
            int boarded = Math.min(4, waiting);
            waiting -= boarded;
            rotation++;
            profit += boarded * boardingCost - runningCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                bestRound = rotation;
            }
        }
        return bestRound;
    }
}
