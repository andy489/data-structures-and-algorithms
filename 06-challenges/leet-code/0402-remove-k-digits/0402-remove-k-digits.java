// https://leetcode.com/problems/remove-k-digits/

// Solution: Monotonic Stack (Greedy) — O(n) time, O(n) space
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        // Strip leading zeros
        int start = 0;
        while (start < sb.length() - 1 && sb.charAt(start) == '0') {
            start++;
        }
        return sb.substring(start);
    }
}
