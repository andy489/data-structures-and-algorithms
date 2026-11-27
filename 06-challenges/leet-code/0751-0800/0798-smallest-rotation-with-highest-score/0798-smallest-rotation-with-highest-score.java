// https://leetcode.com/problems/smallest-rotation-with-highest-score/

// Solution: Difference Array — O(n) time, O(n) space
class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] change = new int[n];
        for (int i = 0; i < n; i++) {
            int lo = (i - nums[i] + 1 + n) % n;
            int hi = i;
            change[lo]--;
            if (lo > hi) {
                change[0]--;
            }
            if (hi + 1 < n) {
                change[hi + 1]++;
            }
        }
        int best = 0, score = n, curr = n;
        for (int k = 1; k < n; k++) {
            curr += change[k];
            if (curr > score) {
                score = curr;
                best = k;
            }
        }
        return best;
    }
}
