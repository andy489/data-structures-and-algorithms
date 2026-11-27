// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

// Solution: Stack — O(n²) time, O(n) space
class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.push(new StringBuilder());
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder top = stack.pop();
                top.reverse();
                stack.peek().append(top);
            } else {
                stack.peek().append(c);
            }
        }
        return stack.peek().toString();
    }
}

// Solution 2: Wormhole (Portal) Trick — O(n) time, O(n) space
class Solution2 {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int dir = 1;
        for (int i = 0; i >= 0 && i < n; i += dir) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = pair[i];
                dir = -dir;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
