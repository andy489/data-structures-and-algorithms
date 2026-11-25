// https://leetcode.com/problems/sum-of-subsequence-widths/

// Solution: Sort + Combinatorics — O(n log n) time, O(n) space
class Solution {
    public int sumSubseqWidths(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        Arrays.sort(nums);
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (pow2[i] - pow2[n - 1 - i]) % MOD * nums[i]) % MOD;
        }
        return (int) ((ans + MOD) % MOD);
    }
}
