// https://leetcode.com/problems/decode-string/

// Solution: Stack — O(n * max_k) time, O(n) space
class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(k);
                strStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int times = numStack.pop();
                StringBuilder prev = strStack.pop();
                String segment = current.toString();
                for (int i = 0; i < times; i++) {
                    prev.append(segment);
                }
                current = prev;
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
}
