// https://leetcode.com/problems/maximum-ice-cream-bars/

// Solution: Counting Sort + Greedy — O(n + C) time, O(C) space
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for (int c : costs) {
            maxCost = Math.max(maxCost, c);
        }
        int[] freq = new int[maxCost + 1];
        for (int c : costs) {
            freq[c]++;
        }
        int count = 0;
        for (int c = 1; c <= maxCost && coins >= c; c++) {
            int buy = Math.min(freq[c], coins / c);
            count += buy;
            coins -= buy * c;
        }
        return count;
    }
}
