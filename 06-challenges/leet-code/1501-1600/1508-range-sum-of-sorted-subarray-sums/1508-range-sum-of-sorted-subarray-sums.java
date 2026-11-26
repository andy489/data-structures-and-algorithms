// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/

// Solution: Enumerate and Sort — O(n^2 log n) time, O(n^2) space
class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int total = n * (n + 1) / 2;
        int[] sums = new int[total];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < n; j++) {
                cur += nums[j];
                sums[idx++] = cur;
            }
        }
        Arrays.sort(sums);
        long ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % MOD;
        }
        return (int) ans;
    }
}
