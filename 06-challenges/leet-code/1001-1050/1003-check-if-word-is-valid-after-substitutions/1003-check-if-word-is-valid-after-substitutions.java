// https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/

// Solution: Stack — O(n) time, O(n) space
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.peek() != 'b') {
                    return false;
                }
                stack.pop();
                if (stack.isEmpty() || stack.peek() != 'a') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
