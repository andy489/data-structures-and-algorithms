// https://leetcode.com/problems/largest-rectangle-in-histogram/

// Solution: Monotonic Stack — O(n) time, O(n) space
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (stack.peek() != -1 && heights[stack.peek()] >= h) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
