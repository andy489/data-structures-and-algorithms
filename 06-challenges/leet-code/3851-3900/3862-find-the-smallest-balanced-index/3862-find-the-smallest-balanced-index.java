// https://leetcode.com/problems/find-the-smallest-balanced-index/

class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        long maxSum = prefix[n];
        long suffixProd = 1;
        // Iterate from right to left
        // We need to find smallest i, so check from left; precompute suffix products
        long[] suffProd = new long[n + 1];
        suffProd[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (suffProd[i + 1] > maxSum) {
                suffProd[i] = Long.MAX_VALUE; // overflow guard
            } else {
                suffProd[i] = suffProd[i + 1] * nums[i];
                if (suffProd[i] < 0) {
                    suffProd[i] = Long.MAX_VALUE; // overflow
                }
            }
        }
        for (int i = 0; i < n; i++) {
            long leftSum = prefix[i];
            long rightProd = suffProd[i + 1];
            if (rightProd != Long.MAX_VALUE && leftSum == rightProd) {
                return i;
            }
        }
        return -1;
    }
}
