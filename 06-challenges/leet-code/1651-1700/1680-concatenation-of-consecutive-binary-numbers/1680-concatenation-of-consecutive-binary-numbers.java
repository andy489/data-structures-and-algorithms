// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

// Solution: Bit Shifting — O(n) time, O(1) space
class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long result = 0;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                len++;
            }
            result = ((result << len) | i) % MOD;
        }
        return (int) result;
    }
}
