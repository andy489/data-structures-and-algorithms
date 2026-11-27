// https://leetcode.com/problems/spiral-matrix/

// Solution: Layer Boundaries — O(m·n) time, O(1) space
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                result.add(matrix[top][c]);
            }
            top++;
            for (int r = top; r <= bottom; r++) {
                result.add(matrix[r][right]);
            }
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    result.add(matrix[bottom][c]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    result.add(matrix[r][left]);
                }
                left++;
            }
        }
        return result;
    }
}

// Solution 2: Recursion — O(m·n) time, O(min(m,n)) space
class Solution2 {
    private void solve(int[][] matrix, int top, int bottom, int left, int right, List<Integer> result) {
        if (top > bottom || left > right) {
            return;
        }
        for (int c = left; c <= right; c++) result.add(matrix[top][c]);
        for (int r = top + 1; r <= bottom; r++) result.add(matrix[r][right]);
        if (top < bottom) {
            for (int c = right - 1; c >= left; c--) result.add(matrix[bottom][c]);
        }
        if (left < right) {
            for (int r = bottom - 1; r > top; r--) result.add(matrix[r][left]);
        }
        solve(matrix, top + 1, bottom - 1, left + 1, right - 1, result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        solve(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, result);
        return result;
    }
}
