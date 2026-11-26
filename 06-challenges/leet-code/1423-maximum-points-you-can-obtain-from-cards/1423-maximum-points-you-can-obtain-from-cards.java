// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, total = 0, w = n - k;
        for (int p : cardPoints) total += p;
        if (w == 0) return total;
        int windowSum = 0;
        for (int i = 0; i < w; i++) windowSum += cardPoints[i];
        int minWindow = windowSum;
        for (int i = w; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - w];
            minWindow = Math.min(minWindow, windowSum);
        }
        return total - minWindow;
    }
}
