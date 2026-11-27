// https://leetcode.com/problems/zero-array-transformation-ii/

// Solution: Binary Search + Difference Array — O((n + q) log q) time, O(n) space
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        if (isFeasible(nums, queries, 0)) {
            return 0;
        }

        int lo = 1, hi = q;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isFeasible(nums, queries, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return isFeasible(nums, queries, lo) ? lo : -1;
    }

    private boolean isFeasible(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            diff[queries[i][0]] += queries[i][2];
            diff[queries[i][1] + 1] -= queries[i][2];
        }
        int coverage = 0;
        for (int i = 0; i < n; i++) {
            coverage += diff[i];
            if (coverage < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
