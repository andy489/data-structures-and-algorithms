// https://leetcode.com/problems/truncate-sentence/

// Solution: Split and Join — O(n) time, O(n) space
class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
