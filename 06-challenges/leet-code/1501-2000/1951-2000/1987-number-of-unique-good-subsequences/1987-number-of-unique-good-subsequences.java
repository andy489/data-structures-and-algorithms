// https://leetcode.com/problems/number-of-unique-good-subsequences/

// Solution: DP — O(n) time, O(1) space
class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        final int MOD = 1_000_000_007;
        long ends1 = 0, ends0 = 0;
        boolean hasZero = false;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                ends1 = (ends1 + ends0 + 1) % MOD;
            } else {
                ends0 = (ends0 + ends1) % MOD;
                hasZero = true;
            }
        }
        return (int) ((ends1 + ends0 + (hasZero ? 1 : 0)) % MOD);
    }
}
