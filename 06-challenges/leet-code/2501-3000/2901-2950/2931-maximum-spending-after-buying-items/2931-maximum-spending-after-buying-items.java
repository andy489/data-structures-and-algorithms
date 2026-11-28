// https://leetcode.com/problems/maximum-spending-after-buying-items/

// Solution: Greedy Sort — O(m·n·log(m·n)) time, O(m·n) space
class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        int[] all = new int[m * n];
        int idx = 0;
        for (int[] row : values) {
            for (int v : row) {
                all[idx++] = v;
            }
        }
        Arrays.sort(all);
        long result = 0;
        for (int i = 0; i < all.length; i++) {
            result += (long) all[i] * (i + 1);
        }
        return result;
    }
}
