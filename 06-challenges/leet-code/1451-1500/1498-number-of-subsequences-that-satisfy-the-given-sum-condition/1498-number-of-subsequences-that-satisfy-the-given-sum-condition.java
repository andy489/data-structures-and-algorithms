// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

// Solution: Sort + Two Pointers + Precomputed Powers — O(n log n) time, O(n) space
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        long MOD = 1_000_000_007;
        long[] pw = new long[n];
        pw[0] = 1;
        for (int i = 1; i < n; i++) pw[i] = pw[i-1] * 2 % MOD;
        long ans = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) { ans = (ans + pw[r-l]) % MOD; l++; }
            else r--;
        }
        return (int) ans;
    }
}
