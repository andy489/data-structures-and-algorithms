// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

// Solution: Linear Scan — O(n * m) time, O(1) space
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++)
            if (words[i].startsWith(searchWord)) return i + 1;
        return -1;
    }
}
