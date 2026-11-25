// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

// Solution: Monotonic Stack (same as 316) — O(n) time, O(1) space
class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] onStack = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ci = c - 'a';
            if (onStack[ci]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && lastIdx[stack.peek() - 'a'] > i) {
                onStack[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            onStack[ci] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
