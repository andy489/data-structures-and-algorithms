// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

// Solution: Balance Counter — O(n) time, O(1) space
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (open > 0) {
                open--;
            } else {
                close++;
            }
        }
        return open + close;
    }
}
