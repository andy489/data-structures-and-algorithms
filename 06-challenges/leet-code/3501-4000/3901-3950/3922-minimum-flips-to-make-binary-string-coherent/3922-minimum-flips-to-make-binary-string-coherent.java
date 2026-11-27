// https://leetcode.com/problems/minimum-flips-to-make-binary-string-coherent/

class Solution {
    public int minFlips(String s) {
        int n = s.length();
        // prefix0[i] = number of '0's in s[0..i-1]
        int[] prefix0 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix0[i + 1] = prefix0[i] + (s.charAt(i) == '0' ? 1 : 0);
        }
        // suffix1[i] = number of '1's in s[i..n-1]
        int[] suffix1 = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix1[i] = suffix1[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int ans = n;
        for (int i = 0; i <= n; i++) {
            // flip 0s in left part to 1, flip 1s in right part to 0
            ans = Math.min(ans, prefix0[i] + suffix1[i]);
        }
        return ans;
    }
}
