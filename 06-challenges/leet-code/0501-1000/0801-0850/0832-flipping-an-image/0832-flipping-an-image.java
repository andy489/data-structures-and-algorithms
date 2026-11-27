// https://leetcode.com/problems/flipping-an-image/

// Solution: In-Place Two Pointers — O(n²) time, O(1) space
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int l = 0, r = row.length - 1;
            while (l <= r) {
                if (row[l] == row[r]) {
                    row[l] ^= 1;
                    row[r] = row[l];
                }
                l++;
                r--;
            }
        }
        return image;
    }
}
