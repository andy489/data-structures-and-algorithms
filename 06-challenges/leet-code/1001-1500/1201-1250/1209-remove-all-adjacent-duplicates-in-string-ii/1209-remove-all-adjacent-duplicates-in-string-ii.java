// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

// Solution: Stack — O(n) time, O(n) space
// Solution: Stack — O(n) time, O(n) space
class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) stack.pop();
            } else {
                stack.push(new int[]{c, 1});
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] pair : stack) {
            for (int i = 0; i < pair[1]; i++) sb.append((char) pair[0]);
        }
        return sb.reverse().toString();
    }
}
