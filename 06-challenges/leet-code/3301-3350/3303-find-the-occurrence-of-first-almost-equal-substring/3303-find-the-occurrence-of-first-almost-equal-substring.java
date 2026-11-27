// https://leetcode.com/problems/find-the-occurrence-of-first-almost-equal-substring/

class Solution {
    private int[] zFunction(char[] t) {
        int n = t.length;
        int[] z = new int[n];
        z[0] = n;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i < r) {
                z[i] = Math.min(r - i, z[i - l]);
            }
            while (i + z[i] < n && t[z[i]] == t[i + z[i]]) {
                z[i]++;
            }
            if (i + z[i] > r) {
                l = i;
                r = i + z[i];
            }
        }
        return z;
    }

    public int minStartingIndex(String s, String pattern) {
        int n = s.length(), m = pattern.length();
        char[] fwd = (pattern + "#" + s).toCharArray();
        int[] zPre = zFunction(fwd);

        String sRev = new StringBuilder(s).reverse().toString();
        String pRev = new StringBuilder(pattern).reverse().toString();
        char[] bwd = (pRev + "#" + sRev).toCharArray();
        int[] zSuf = zFunction(bwd);

        for (int i = 0; i <= n - m; i++) {
            int pre = Math.min(zPre[m + 1 + i], m);
            int suf = Math.min(zSuf[m + 1 + (n - m - i)], m);
            if (pre + suf >= m - 1) {
                return i;
            }
        }
        return -1;
    }
}
