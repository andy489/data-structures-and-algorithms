// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

// Solution: One Pass Counter — O(n) time, O(1) space
class Solution {
    public int maxDepth(String s) {
        int depth = 0, maxD = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                maxD = Math.max(maxD, ++depth);
            } else if (c == ')') {
                depth--;
            }
        }
        return maxD;
    }
}
