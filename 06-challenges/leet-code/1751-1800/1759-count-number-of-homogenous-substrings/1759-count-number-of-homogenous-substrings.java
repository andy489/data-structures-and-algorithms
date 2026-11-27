// https://leetcode.com/problems/count-number-of-homogenous-substrings/

// Solution: Run-Length Encoding — O(n) time, O(1) space
class Solution {
    public int countHomogenous(String s) {
        final int MOD = 1_000_000_007;
        long ans = 0;
        int i = 0, n = s.length();
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            long k = j - i;
            ans = (ans + k * (k + 1) / 2) % MOD;
            i = j;
        }
        return (int) ans;
    }
}
