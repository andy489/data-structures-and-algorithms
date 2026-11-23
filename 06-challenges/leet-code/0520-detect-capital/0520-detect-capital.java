// https://leetcode.com/problems/detect-capital/

class Solution {
    public boolean detectCapitalUse(String word) {
        int upCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upCount++;
            }
        }
        return upCount == 0 || upCount == word.length() || (upCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
