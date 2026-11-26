// https://leetcode.com/problems/number-of-valid-words-in-a-sentence/

// Solution: Manual Parse — O(n) time, O(n) space
class Solution {
    public int countValidWords(String sentence) {
        int count = 0;
        for (String token : sentence.trim().split("\\s+")) {
            if (isValid(token)) { count++; }
        }
        return count;
    }
    private boolean isValid(String t) {
        if (t.isEmpty()) { return false; }
        int n = t.length(), hyphens = 0;
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (Character.isDigit(c)) { return false; }
            if (c == '-') {
                if (++hyphens > 1 || i == 0 || i == n - 1 || !Character.isLetter(t.charAt(i - 1)) || !Character.isLetter(t.charAt(i + 1))) { return false; }
            }
            if ((c == '!' || c == '.' || c == ',') && i != n - 1) { return false; }
        }
        return true;
    }
}
