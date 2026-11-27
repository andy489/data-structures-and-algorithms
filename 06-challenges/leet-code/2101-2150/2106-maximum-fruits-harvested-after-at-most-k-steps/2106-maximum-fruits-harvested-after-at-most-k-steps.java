// https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/

// Solution: Sliding Window — O(n) time, O(1) extra space
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int left = 0;
        int windowSum = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {
            windowSum += fruits[right][1];

            // Shrink window from left while interval [fruits[left][0], fruits[right][0]]
            // is not reachable from startPos in k steps
            while (left <= right && !reachable(fruits[left][0], fruits[right][0], startPos, k)) {
                windowSum -= fruits[left][1];
                left++;
            }

            result = Math.max(result, windowSum);
        }

        return result;
    }

    private boolean reachable(int L, int R, int startPos, int k) {
        if (R < startPos) {
            // Only go left: need startPos - L steps
            return startPos - L <= k;
        }
        if (L > startPos) {
            // Only go right: need R - startPos steps
            return R - startPos <= k;
        }
        // L <= startPos <= R: go both ways
        // Cost = (R - L) + min(startPos - L, R - startPos)
        return (R - L) + Math.min(startPos - L, R - startPos) <= k;
    }
}
