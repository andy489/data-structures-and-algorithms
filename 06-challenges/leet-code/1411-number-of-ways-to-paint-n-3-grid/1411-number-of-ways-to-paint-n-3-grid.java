// https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/

// Solution: Pattern Count DP — O(n) time, O(1) space
class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007, aba = 12, abc = 6;
        for (int i = 1; i < n; i++) {
            long nAba = (3 * aba + 2 * abc) % MOD;
            long nAbc = (2 * aba + 2 * abc) % MOD;
            aba = nAba; abc = nAbc;
        }
        return (int) ((aba + abc) % MOD);
    }
}
