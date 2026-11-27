// https://leetcode.com/problems/sum-of-scores-of-built-strings/
class Solution {
    public long sumScores(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i < r) {
                z[i] = Math.min(r - i, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] > r) {
                l = i;
                r = i + z[i];
            }
        }
        long sum = n;
        for (int i = 1; i < n; i++) {
            sum += z[i];
        }
        return sum;
    }
}
