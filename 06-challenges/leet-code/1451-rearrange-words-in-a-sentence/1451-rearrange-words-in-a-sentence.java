// https://leetcode.com/problems/rearrange-words-in-a-sentence/

// Solution: Stable Sort — O(n log n) time, O(n) space
class Solution {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        words[0] = Character.toUpperCase(words[0].charAt(0)) + words[0].substring(1);
        return String.join(" ", words);
    }
}
