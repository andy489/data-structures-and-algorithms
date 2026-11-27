// https://leetcode.com/problems/find-missing-and-repeated-values/
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;
        int[] count = new int[total + 1];
        for (int[] row : grid) {
            for (int val : row) {
                count[val]++;
            }
        }
        int repeated = -1, missing = -1;
        for (int i = 1; i <= total; i++) {
            if (count[i] == 2) {
                repeated = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }
        return new int[]{repeated, missing};
    }
}
