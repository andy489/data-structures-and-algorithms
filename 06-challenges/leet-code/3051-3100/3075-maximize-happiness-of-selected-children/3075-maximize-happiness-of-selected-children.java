// https://leetcode.com/problems/maximize-happiness-of-selected-children/

// Solution: Greedy + Sort — O(n log n) time, O(1) space
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        java.util.Arrays.sort(happiness);
        long total = 0;
        int n = happiness.length;
        for (int i = 0; i < k; i++) {
            total += Math.max(0, happiness[n - 1 - i] - i);
        }
        return total;
    }
}
