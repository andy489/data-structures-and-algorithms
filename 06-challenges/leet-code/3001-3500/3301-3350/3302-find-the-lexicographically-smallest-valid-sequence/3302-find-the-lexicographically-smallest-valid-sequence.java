// https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] suf = new int[n + 1];
        int j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = m - 1 - j;
        }
        int[] ans = new int[m];
        int idx = 0;
        boolean usedChange = false;
        for (int i = 0; i < n && idx < m; i++) {
            if (word1.charAt(i) == word2.charAt(idx)) {
                ans[idx++] = i;
            } else if (!usedChange && idx + suf[i + 1] >= m) {
                ans[idx++] = i;
                usedChange = true;
            }
        }
        if (idx < m) {
            return new int[0];
        }
        return ans;
    }
}
