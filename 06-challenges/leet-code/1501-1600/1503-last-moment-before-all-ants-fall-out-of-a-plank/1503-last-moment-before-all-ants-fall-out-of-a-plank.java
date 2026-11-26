// https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/

// Solution: Key Insight (Collisions = Pass-Through) — O(n) time, O(1) space
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int pos : left) {
            ans = Math.max(ans, pos);
        }
        for (int pos : right) {
            ans = Math.max(ans, n - pos);
        }
        return ans;
    }
}
