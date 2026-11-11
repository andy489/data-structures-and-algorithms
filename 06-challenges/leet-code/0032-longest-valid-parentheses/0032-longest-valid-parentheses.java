// https://leetcode.com/problems/longest-valid-parentheses/

// Solution: Stack — O(n) time, O(n) space
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}

// Solution2: Two-Pass Counters — O(n) time, O(1) space
class Solution2 {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                ans = Math.max(ans, 2 * close);
            } else if (close > open) {
                open = close = 0;
            }
        }
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                ans = Math.max(ans, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }
        return ans;
    }
}
