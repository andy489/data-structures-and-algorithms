// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

// Solution: Row min + Col max — O(m*n) time, O(m+n) space
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] rowMin = new int[m], colMax = new int[n];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
        for (int j = 0; j < n; j++) for (int i = 0; i < m; i++) colMax[j] = Math.max(colMax[j], matrix[i][j]);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) res.add(matrix[i][j]);
        return res;
    }
}
