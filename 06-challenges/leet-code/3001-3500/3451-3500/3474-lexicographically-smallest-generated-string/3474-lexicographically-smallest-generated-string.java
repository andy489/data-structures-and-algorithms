// https://leetcode.com/problems/lexicographically-smallest-generated-string/

// Solution: Greedy + KMP — O(n*m) time, O(n+m) space
class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] word = new char[n + m - 1];
        java.util.Arrays.fill(word, 'a');
        // Stamp all T positions
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != 'a' && word[i + j] != str2.charAt(j)) {
                        return "";
                    }
                    word[i + j] = str2.charAt(j);
                }
            }
        }
        // Fix F positions: if the window equals str2, increment last char
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    // Increment the last character of this window
                    int pos = i + m - 1;
                    if (str1.length() > pos / m && pos < n + m - 1) {
                        // Check if position pos is forced by a T
                        boolean forced = false;
                        for (int k = Math.max(0, pos - m + 1); k <= Math.min(n - 1, pos); k++) {
                            if (str1.charAt(k) == 'T') {
                                forced = true;
                                break;
                            }
                        }
                        if (forced) {
                            return "";
                        }
                    }
                    word[pos]++;
                }
            }
        }
        // Validate all T windows
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        return "";
                    }
                }
            }
        }
        return new String(word);
    }
}
