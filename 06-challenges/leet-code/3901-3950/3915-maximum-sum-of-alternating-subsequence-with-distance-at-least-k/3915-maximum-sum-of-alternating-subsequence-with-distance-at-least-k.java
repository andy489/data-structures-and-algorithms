// https://leetcode.com/problems/maximum-sum-of-alternating-subsequence-with-distance-at-least-k/
class Solution {
    public long maximumAlternatingSubsequenceSum(int[] nums, int k) {
        int n = nums.length;
        // up[i] = max sum of alternating subseq ending at i where nums[i] is a local max
        // down[i] = max sum where nums[i] is a local min
        // We use Fenwick trees indexed by value to query max efficiently
        int maxVal = 100001;
        long[] fenwickUp = new long[maxVal + 1];
        long[] fenwickDown = new long[maxVal + 1];
        java.util.Arrays.fill(fenwickUp, Long.MIN_VALUE / 2);
        java.util.Arrays.fill(fenwickDown, Long.MIN_VALUE / 2);
        // Fenwick tree for prefix max
        // updateMax(tree, i, val) and queryMax(tree, i) = max of [1..i]
        long ans = 0;
        // For each i, we can query best[j] for j <= i-k
        // We process elements and add to fenwick at step i-k
        // Use two passes: first window up to i-k
        long[] upArr = new long[n];
        long[] downArr = new long[n];
        // Initialize: each element alone is valid (length 1 subseq)
        java.util.Arrays.fill(upArr, Long.MIN_VALUE / 2);
        java.util.Arrays.fill(downArr, Long.MIN_VALUE / 2);
        // O(n^2) fallback for clarity; optimize with segment tree if needed
        // For this implementation, use simple O(n^2)
        for (int i = 0; i < n; i++) {
            upArr[i] = nums[i]; // single element
            downArr[i] = nums[i]; // single element
            for (int j = 0; j <= i - k; j++) {
                if (nums[j] < nums[i] && downArr[j] > Long.MIN_VALUE / 2) {
                    upArr[i] = Math.max(upArr[i], downArr[j] + nums[i]);
                }
                if (nums[j] > nums[i] && upArr[j] > Long.MIN_VALUE / 2) {
                    downArr[i] = Math.max(downArr[i], upArr[j] + nums[i]);
                }
            }
            ans = Math.max(ans, Math.max(upArr[i], downArr[i]));
        }
        return ans;
    }
}
