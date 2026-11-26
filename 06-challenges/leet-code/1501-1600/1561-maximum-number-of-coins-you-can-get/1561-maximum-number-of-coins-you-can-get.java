// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

// Solution: Greedy Sort — O(n log n) time, O(1) space
class Solution {
    public int maxCoins(int[] piles) {
        java.util.Arrays.sort(piles);
        int n = piles.length / 3;
        int sum = 0;
        for (int i = piles.length - 2; i >= n; i -= 2) {
            sum += piles[i];
        }
        return sum;
    }
}
