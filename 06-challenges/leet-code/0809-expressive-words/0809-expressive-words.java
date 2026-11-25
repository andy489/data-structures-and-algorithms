// https://leetcode.com/problems/expressive-words/

// Solution: Run-Length Encoding — O(|s| + sum|words|) time, O(|s|) space
class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isStretchy(String s, String w) {
        int i = 0, j = 0;
        while (i < s.length() && j < w.length()) {
            if (s.charAt(i) != w.charAt(j)) {
                return false;
            }
            int sc = 1, wc = 1;
            while (i + sc < s.length() && s.charAt(i + sc) == s.charAt(i)) {
                sc++;
            }
            while (j + wc < w.length() && w.charAt(j + wc) == w.charAt(j)) {
                wc++;
            }
            if (sc != wc && (sc < 3 || sc < wc)) {
                return false;
            }
            i += sc;
            j += wc;
        }
        return i == s.length() && j == w.length();
    }
}
