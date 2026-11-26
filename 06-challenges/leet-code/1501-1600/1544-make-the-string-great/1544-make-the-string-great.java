// https://leetcode.com/problems/make-the-string-great/

// Solution: Stack — O(n) time, O(n) space
class Solution {
    public String makeGood(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && Math.abs(stack.charAt(len - 1) - c) == 32) {
                stack.deleteCharAt(len - 1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
