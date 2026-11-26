// https://leetcode.com/problems/decode-ways/

// Solution: 1D DP (Space-Optimized) — O(n) time, O(1) space
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int prev2 = 1, prev1 = 1;
        for (int i = 2; i <= s.length(); i++) {
            int curr = 0;
            if (s.charAt(i - 1) != '0') curr += prev1;
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) curr += prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
