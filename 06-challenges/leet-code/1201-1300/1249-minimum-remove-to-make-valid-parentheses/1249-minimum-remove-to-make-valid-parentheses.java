// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

// Solution: Stack — O(n) time, O(n) space
// Solution: Stack — O(n) time, O(n) space
class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                if (!stack.isEmpty()) stack.pop();
                else arr[i] = 0;
            }
        }
        while (!stack.isEmpty()) arr[stack.pop()] = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : arr) if (c != 0) sb.append(c);
        return sb.toString();
    }
}
