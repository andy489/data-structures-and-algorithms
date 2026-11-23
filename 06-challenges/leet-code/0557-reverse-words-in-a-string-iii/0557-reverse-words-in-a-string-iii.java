// https://leetcode.com/problems/reverse-words-in-a-string-iii/
// Solution: Per-word reverse — O(n) time, O(n) space
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(new StringBuilder(words[i]).reverse());
        }
        return sb.toString();
    }
}
