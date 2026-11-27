// https://leetcode.com/problems/decode-ways-ii/

// Solution: DP — O(n) time, O(1) space
class Solution {
    public int numDecodings(String s) {
        long MOD = 1_000_000_007;
        long prev2 = 1;
        long prev1 = s.charAt(0) == '*' ? 9 : (s.charAt(0) == '0' ? 0 : 1);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i - 1);
            long single = (cur == '*') ? 9 : (cur == '0' ? 0 : 1);
            long twoDigit = 0;
            if (pre == '*' && cur == '*') {
                twoDigit = 15; // 11-19 (9) + 21-26 (6)
            } else if (pre == '*') {
                twoDigit = (cur <= '6') ? 2 : 1; // 1X and optionally 2X
            } else if (cur == '*') {
                if (pre == '1') {
                    twoDigit = 9;
                } else if (pre == '2') {
                    twoDigit = 6;
                }
            } else {
                int twoNum = (pre - '0') * 10 + (cur - '0');
                twoDigit = (twoNum >= 10 && twoNum <= 26) ? 1 : 0;
            }
            long curr = (single * prev1 + twoDigit * prev2) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }
        return (int) prev1;
    }
}
