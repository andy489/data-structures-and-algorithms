// https://leetcode.com/problems/construct-quad-tree/

// Solution: Recursive Divide and Conquer with Prefix Sum — O(n^2) time, O(n^2) space
class Solution {
    private int[][] prefixSum;

    private int rangeSum(int r1, int c1, int r2, int c2) {
        return prefixSum[r2 + 1][c2 + 1]
             - prefixSum[r1][c2 + 1]
             - prefixSum[r2 + 1][c1]
             + prefixSum[r1][c1];
    }

    private Node build(int row, int col, int size) {
        int total = rangeSum(row, col, row + size - 1, col + size - 1);
        if (total == 0) {
            return new Node(false, true);
        }
        if (total == size * size) {
            return new Node(true, true);
        }
        int half = size / 2;
        return new Node(
            true,
            false,
            build(row,        col,        half),
            build(row,        col + half, half),
            build(row + half, col,        half),
            build(row + half, col + half, half)
        );
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        prefixSum = new int[n + 1][n + 1];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                prefixSum[r + 1][c + 1] = grid[r][c]
                    + prefixSum[r][c + 1]
                    + prefixSum[r + 1][c]
                    - prefixSum[r][c];
            }
        }
        return build(0, 0, n);
    }
}
