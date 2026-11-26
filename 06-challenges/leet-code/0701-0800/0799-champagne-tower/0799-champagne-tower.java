// https://leetcode.com/problems/champagne-tower/

// Solution: Row-by-Row Simulation — O(query_row²) time, O(query_row) space
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = new double[]{poured};
        for (int i = 0; i < query_row; i++) {
            double[] next = new double[i + 2];
            for (int j = 0; j <= i; j++) {
                if (row[j] > 1) {
                    double overflow = (row[j] - 1) / 2.0;
                    next[j] += overflow;
                    next[j + 1] += overflow;
                    row[j] = 1;
                }
            }
            row = next;
        }
        return Math.min(1.0, row[query_glass]);
    }
}
