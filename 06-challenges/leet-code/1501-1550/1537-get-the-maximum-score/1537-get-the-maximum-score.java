// https://leetcode.com/problems/get-the-maximum-score/

// Solution: Two Pointer DP — O(n + m) time, O(1) space
class Solution {
    private static final int MOD = 1_000_000_007;

    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else if (j < nums2.length && (i >= nums1.length || nums2[j] < nums1[i])) {
                sum2 += nums2[j++];
            } else {
                // common element
                long best = Math.max(sum1, sum2) + nums1[i];
                sum1 = best;
                sum2 = best;
                i++;
                j++;
            }
        }
        return (int) (Math.max(sum1, sum2) % MOD);
    }
}
