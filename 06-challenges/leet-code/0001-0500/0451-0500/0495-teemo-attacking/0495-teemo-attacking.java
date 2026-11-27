// https://leetcode.com/problems/teemo-attacking/

// Solution: Greedy Interval Merge — O(n) time, O(1) space
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            total += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        total += duration;
        return total;
    }
}
