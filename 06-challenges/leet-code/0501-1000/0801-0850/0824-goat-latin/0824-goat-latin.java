// https://leetcode.com/problems/goat-latin/

// Solution: String Manipulation — O(n²) time, O(n) space
class Solution {
    public String toGoatLatin(String sentence) {
        String vowels = "aeiouAEIOU";
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            String w = words[i];
            if (vowels.indexOf(w.charAt(0)) >= 0) {
                sb.append(w).append("ma");
            } else {
                sb.append(w.substring(1)).append(w.charAt(0)).append("ma");
            }
            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }
        }
        return sb.toString();
    }
}
