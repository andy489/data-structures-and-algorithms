// https://leetcode.com/problems/maximum-matrix-sum/

// Solution: Greedy — O(n^2) time, O(1) space
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negCount = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                totalSum += Math.abs(val);
                if (val < 0) {
                    negCount++;
                }
                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }
        if (negCount % 2 == 0) {
            return totalSum;
        }
        return totalSum - 2L * minAbs;
    }
}
