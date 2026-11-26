// https://leetcode.com/problems/count-submatrices-with-all-ones/

// Solution: Height Array + Stack — O(m*n) time, O(n) space
class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 1 ? height[j] + 1 : 0;
            }
            result += countFromRow(height);
        }
        return result;
    }

    private int countFromRow(int[] height) {
        int n = height.length, count = 0, sum = 0;
        // stack stores [h, width]
        int[][] stack = new int[n][2];
        int top = -1;
        for (int j = 0; j < n; j++) {
            int width = 1;
            while (top >= 0 && stack[top][0] >= height[j]) {
                sum -= stack[top][0] * stack[top][1];
                width += stack[top][1];
                top--;
            }
            sum += height[j] * width;
            count += sum;
            stack[++top] = new int[]{height[j], width};
        }
        return count;
    }
}
