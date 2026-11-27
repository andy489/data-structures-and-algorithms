// https://leetcode.com/problems/count-ways-to-group-overlapping-ranges/

class Solution {
    private static final int MOD = 1_000_000_007;

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int components = 0;
        int maxEnd = -1;
        for (int[] r : ranges) {
            if (r[0] > maxEnd) {
                components++;
            }
            maxEnd = Math.max(maxEnd, r[1]);
        }
        long result = 1;
        for (int i = 0; i < components; i++) {
            result = result * 2 % MOD;
        }
        return (int) result;
    }
}
