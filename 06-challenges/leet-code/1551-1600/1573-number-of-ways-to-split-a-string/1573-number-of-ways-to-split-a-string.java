// https://leetcode.com/problems/number-of-ways-to-split-a-string/

// Solution: Count Ones and Math — O(n) time, O(1) space
class Solution {
    static final int MOD = 1_000_000_007;

    public int numWays(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        int n = s.length();
        if (ones % 3 != 0) {
            return 0;
        }
        if (ones == 0) {
            return (int) ((long) (n - 1) * (n - 2) / 2 % MOD);
        }
        int third = ones / 3;
        long gap1 = 0, gap2 = 0;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            }
            if (cnt == third) {
                gap1++;
            } else if (cnt == 2 * third) {
                gap2++;
            }
        }
        return (int) (gap1 % MOD * (gap2 % MOD) % MOD);
    }
}
