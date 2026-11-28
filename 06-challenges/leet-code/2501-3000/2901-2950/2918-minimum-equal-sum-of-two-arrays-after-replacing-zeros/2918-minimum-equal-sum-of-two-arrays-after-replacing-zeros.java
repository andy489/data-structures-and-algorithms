// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/

// Solution: Greedy Min Sum — O(n + m) time, O(1) space
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, zeros1 = 0;
        for (int x : nums1) {
            sum1 += x;
            if (x == 0) {
                zeros1++;
            }
        }
        long sum2 = 0, zeros2 = 0;
        for (int x : nums2) {
            sum2 += x;
            if (x == 0) {
                zeros2++;
            }
        }

        long minSum1 = sum1 + zeros1;
        long minSum2 = sum2 + zeros2;

        if (minSum1 == minSum2) {
            return minSum1;
        }
        if (minSum1 < minSum2) {
            return zeros1 > 0 ? minSum2 : -1;
        }
        return zeros2 > 0 ? minSum1 : -1;
    }
}
