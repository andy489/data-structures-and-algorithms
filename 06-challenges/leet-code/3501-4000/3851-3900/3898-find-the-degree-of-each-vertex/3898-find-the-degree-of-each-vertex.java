// https://leetcode.com/problems/find-the-degree-of-each-vertex/
class Solution {
    public int[] findDegree(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int deg = 0;
            for (int j = 0; j < n; j++) {
                deg += matrix[i][j];
            }
            ans[i] = deg;
        }
        return ans;
    }
}
