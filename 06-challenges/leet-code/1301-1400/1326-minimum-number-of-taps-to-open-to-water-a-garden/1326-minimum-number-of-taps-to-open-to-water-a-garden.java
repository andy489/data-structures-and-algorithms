// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/

// Solution: Greedy interval cover — O(n) time, O(n) space
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxRight = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            maxRight[left] = Math.max(maxRight[left], i + ranges[i]);
        }
        int taps = 0, curEnd = 0, farthest = 0;
        for (int i = 0; i <= n; i++) {
            farthest = Math.max(farthest, maxRight[i]);
            if (i == curEnd) {
                if (i < n) {
                    if (farthest == curEnd) return -1;
                    taps++;
                    curEnd = farthest;
                }
            }
        }
        return taps;
    }
}
