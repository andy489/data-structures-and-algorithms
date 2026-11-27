// https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/

// Solution: Greedy Row Selection — O(n^2) time, O(n) space
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    zeros++;
                } else {
                    break;
                }
            }
            trailingZeros[i] = zeros;
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int need = n - 1 - i;
            int found = -1;
            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= need) {
                    found = j;
                    break;
                }
            }
            if (found == -1) {
                return -1;
            }
            while (found > i) {
                int tmp = trailingZeros[found];
                trailingZeros[found] = trailingZeros[found - 1];
                trailingZeros[found - 1] = tmp;
                found--;
                swaps++;
            }
        }
        return swaps;
    }
}
