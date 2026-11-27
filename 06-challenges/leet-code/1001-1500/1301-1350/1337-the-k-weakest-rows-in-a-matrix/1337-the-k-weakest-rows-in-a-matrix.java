// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

// Solution: Sort — O(m log n + m log m) time, O(m) space
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int[][] rows = new int[m][2];
        for (int i = 0; i < m; i++) {
            rows[i][0] = countSoldiers(mat[i]);
            rows[i][1] = i;
        }
        Arrays.sort(rows, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = rows[i][1];
        return ans;
    }
    private int countSoldiers(int[] row) {
        int lo = 0, hi = row.length;
        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (row[mid] == 1) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}
