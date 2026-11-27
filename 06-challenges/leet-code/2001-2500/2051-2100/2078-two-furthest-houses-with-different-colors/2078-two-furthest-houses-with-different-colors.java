// https://leetcode.com/problems/two-furthest-houses-with-different-colors/

// Solution: Two Passes — O(n) time, O(1) space
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length, res = 0;
        for (int j = n - 1; j > 0; j--) {
            if (colors[j] != colors[0]) { res = Math.max(res, j); break; }
        }
        for (int i = 0; i < n - 1; i++) {
            if (colors[i] != colors[n - 1]) { res = Math.max(res, n - 1 - i); break; }
        }
        return res;
    }
}
