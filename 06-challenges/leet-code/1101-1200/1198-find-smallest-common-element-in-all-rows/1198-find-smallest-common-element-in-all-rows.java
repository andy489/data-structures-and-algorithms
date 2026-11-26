// https://leetcode.com/problems/find-smallest-common-element-in-all-rows/

// Solution: Count Array — O(m*n) time, O(max_val) space
class Solution {
    public int smallestCommonElement(int[][] mat) {
        int[] count = new int[10001];
        for (int[] row : mat) {
            for (int v : row) {
                count[v]++;
            }
        }
        for (int v : mat[0]) {
            if (count[v] == mat.length) {
                return v;
            }
        }
        return -1;
    }
}
