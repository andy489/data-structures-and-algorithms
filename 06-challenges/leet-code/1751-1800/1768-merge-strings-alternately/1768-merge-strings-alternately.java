// https://leetcode.com/problems/merge-strings-alternately/

// Solution: Two Pointer — O(n+m) time, O(n+m) space
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        while (i < word1.length()) sb.append(word1.charAt(i++));
        while (j < word2.length()) sb.append(word2.charAt(j++));
        return sb.toString();
    }
}
