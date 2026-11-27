// https://leetcode.com/problems/count-total-number-of-colored-cells/

class Solution {
    public long coloredCells(int n) {
        return 1L + 2L * n * (n - 1);
    }
}
