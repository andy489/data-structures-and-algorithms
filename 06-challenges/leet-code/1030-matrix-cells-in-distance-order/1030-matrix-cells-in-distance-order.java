// https://leetcode.com/problems/matrix-cells-in-distance-order/

// Solution: Sort — O(r·c·log(r·c)) time, O(r·c) space
class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][2];
        int idx = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[idx++] = new int[]{r, c};
            }
        }
        Arrays.sort(result, (a, b) ->
            (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)) -
            (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter)));
        return result;
    }
}
