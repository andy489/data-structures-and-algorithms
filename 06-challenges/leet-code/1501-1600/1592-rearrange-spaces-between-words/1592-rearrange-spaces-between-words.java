// https://leetcode.com/problems/rearrange-spaces-between-words/

// Solution: String Split — O(n) time, O(n) space
class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') spaces++;
        }
        String[] words = text.trim().split("\\s+");
        int gaps = words.length - 1;
        int between = gaps == 0 ? 0 : spaces / gaps;
        int trailing = spaces - between * gaps;
        StringBuilder sep = new StringBuilder();
        for (int i = 0; i < between; i++) {
            sep.append(' ');
        }
        StringBuilder result = new StringBuilder();
        result.append(String.join(sep.toString(), words));
        for (int i = 0; i < trailing; i++) {
            result.append(' ');
        }
        return result.toString();
    }
}
