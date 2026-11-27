// https://leetcode.com/problems/richest-customer-wealth/

// Solution: Row Sum Maximum — O(m * n) time, O(1) space
class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] customer : accounts) {
            int wealth = 0;
            for (int account : customer) {
                wealth += account;
            }
            maxWealth = Math.max(maxWealth, wealth);
        }
        return maxWealth;
    }
}
