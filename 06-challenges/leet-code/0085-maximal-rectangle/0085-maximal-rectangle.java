// https://leetcode.com/problems/maximal-rectangle/

// Solution: Histogram per Row (LC 84) — O(m·n) time, O(n) space
class Solution {
    private int largestInHistogram(int[] heights) {
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

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestInHistogram(heights));
        }
        return maxArea;
    }
}
