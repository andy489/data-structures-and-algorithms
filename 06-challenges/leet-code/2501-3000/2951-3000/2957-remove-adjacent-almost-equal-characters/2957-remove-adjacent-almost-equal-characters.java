// https://leetcode.com/problems/remove-adjacent-almost-equal-characters/
class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int ops = 0;
        int i = 1;
        while (i < word.length()) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 1) {
                ops++;
                i += 2;
            } else {
                i++;
            }
        }
        return ops;
    }
}
