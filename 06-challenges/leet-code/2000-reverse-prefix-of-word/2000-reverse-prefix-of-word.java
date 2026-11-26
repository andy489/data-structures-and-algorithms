// https://leetcode.com/problems/reverse-prefix-of-word/

// Solution: Simulation — O(n) time, O(n) space
class Solution {
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if (i == -1) { return word; }
        return new StringBuilder(word.substring(0, i + 1)).reverse() + word.substring(i + 1);
    }
}
