// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

// Solution: Row/Column Parity — O(indices.length + m + n) time, O(m + n) space
// Solution: Row/Column Parity — O(L+m+n) time, O(m+n) space
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m], col = new int[n];
        for (int[] idx : indices) { row[idx[0]]++; col[idx[1]]++; }
        int oddR = 0, oddC = 0;
        for (int r : row) if (r % 2 != 0) oddR++;
        for (int c : col) if (c % 2 != 0) oddC++;
        return oddR * (n - oddC) + (m - oddR) * oddC;
    }
}
