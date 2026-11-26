// https://leetcode.com/problems/score-of-parentheses/

// Solution: Stack — O(n) time, O(n) space
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                stack.push(stack.pop() + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }
}
