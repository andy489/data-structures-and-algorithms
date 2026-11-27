// https://leetcode.com/problems/largest-merge-of-two-strings/

// Solution: Greedy Suffix Comparison — O((m+n)·min(m,n)) time, O(m+n) space
class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            // Compare suffixes
            if (word1.substring(i).compareTo(word2.substring(j)) >= 0) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
