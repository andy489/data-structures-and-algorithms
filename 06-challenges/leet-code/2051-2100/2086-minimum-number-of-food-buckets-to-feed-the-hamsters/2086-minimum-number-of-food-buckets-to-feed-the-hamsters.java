// https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public int minimumBuckets(String hamsters) {
        char[] h = hamsters.toCharArray();
        int n = h.length, count = 0;
        for (int i = 0; i < n; i++) {
            if (h[i] == 'H') {
                if (i + 1 < n && h[i + 1] == '#') { h[i + 1] = 'B'; count++; }
                else if (i - 1 >= 0 && h[i - 1] == '#') { count++; }
                else { return -1; }
            }
        }
        return count;
    }
}
