// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

// Solution: Subsequence Check — O(d·n) time, O(1) space
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > result.length() ||
                    (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean isSubsequence(String word, String s) {
        int wordIdx = 0;
        for (int sIdx = 0; sIdx < s.length() && wordIdx < word.length(); sIdx++) {
            if (s.charAt(sIdx) == word.charAt(wordIdx)) {
                wordIdx++;
            }
        }
        return wordIdx == word.length();
    }
}
