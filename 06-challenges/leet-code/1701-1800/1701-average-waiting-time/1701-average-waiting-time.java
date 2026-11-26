// https://leetcode.com/problems/average-waiting-time/

// Solution: Greedy Simulation — O(n) time, O(1) space
class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWait = 0;
        long chefFreeAt = 0;
        for (int[] customer : customers) {
            long arrival = customer[0];
            long prepTime = customer[1];
            chefFreeAt = Math.max(chefFreeAt, arrival) + prepTime;
            totalWait += chefFreeAt - arrival;
        }
        return (double) totalWait / customers.length;
    }
}
