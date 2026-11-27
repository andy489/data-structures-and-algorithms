// https://leetcode.com/problems/k-th-smallest-remaining-even-integer-in-subarray-queries/
class Solution {
    public long[] kthSmallest(int[] nums, int[][] queries) {
        int n = nums.length;
        // Precompute prefix sums of even values for binary search
        // For a query [l,r,k]: binary search on answer m (we want 2*m)
        // Count of evens in nums[l..r] <= 2*m = number of even nums[i] in [l..r] with nums[i] <= 2*m
        // Since nums is sorted, use binary search
        long[] ans = new long[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0], r = queries[q][1];
            long k = queries[q][2];
            // Binary search on m: find smallest m such that m - countEvens(l,r,2m) >= k
            long lo = k, hi = k + (long)(r - l + 1);
            while (lo < hi) {
                long mid = (lo + hi) / 2;
                long removed = countEvensLeq(nums, l, r, 2 * mid);
                if (mid - removed >= k) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            ans[q] = 2 * lo;
        }
        return ans;
    }

    private long countEvensLeq(int[] nums, int l, int r, long val) {
        // Count even integers in nums[l..r] that are <= val
        long count = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= val) {
                count++;
            } else if (nums[i] > val) {
                break;
            }
        }
        return count;
    }
}
