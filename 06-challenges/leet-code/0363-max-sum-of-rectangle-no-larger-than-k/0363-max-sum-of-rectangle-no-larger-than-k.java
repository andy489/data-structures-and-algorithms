// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

// Solution: Column Compression + Prefix Sum + TreeSet — O(m²·n log n) time, O(m) space
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++) {
            int[] rowSum = new int[m];
            for (int r = l; r < n; r++) {
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][r];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int prefix = 0;
                for (int sum : rowSum) {
                    prefix += sum;
                    Integer ceiling = set.ceiling(prefix - k);
                    if (ceiling != null) {
                        ans = Math.max(ans, prefix - ceiling);
                    }
                    set.add(prefix);
                }
            }
        }
        return ans;
    }
}
