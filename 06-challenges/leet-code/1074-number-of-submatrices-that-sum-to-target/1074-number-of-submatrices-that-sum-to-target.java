// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/

// Solution: 2D Prefix Sum + HashMap — O(m²*n) time, O(m*n) space
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, count = 0;
        for (int r1 = 0; r1 < m; r1++) {
            int[] colSum = new int[n];
            for (int r2 = r1; r2 < m; r2++) {
                for (int c = 0; c < n; c++) {
                    colSum[c] += matrix[r2][c];
                }
                Map<Integer, Integer> prefixCount = new HashMap<>();
                prefixCount.put(0, 1);
                int prefix = 0;
                for (int c = 0; c < n; c++) {
                    prefix += colSum[c];
                    count += prefixCount.getOrDefault(prefix - target, 0);
                    prefixCount.merge(prefix, 1, Integer::sum);
                }
            }
        }
        return count;
    }
}
