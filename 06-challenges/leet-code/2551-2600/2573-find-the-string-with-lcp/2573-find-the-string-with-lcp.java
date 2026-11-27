// https://leetcode.com/problems/find-the-string-with-lcp/

class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];

        // Greedy: assign smallest possible character
        int nextChar = 0;
        for (int i = 0; i < n; i++) {
            if (word[i] != 0) {
                continue;
            }
            if (nextChar >= 26) {
                return "";
            }
            word[i] = (char) ('a' + nextChar++);
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    if (word[j] != 0 && word[j] != word[i]) {
                        return "";
                    }
                    word[j] = word[i];
                }
            }
        }

        // Validate: compute actual LCP and compare
        int[][] actual = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    actual[i][j] = actual[i + 1][j + 1] + 1;
                } else {
                    actual[i][j] = 0;
                }
                if (actual[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(word);
    }
}
