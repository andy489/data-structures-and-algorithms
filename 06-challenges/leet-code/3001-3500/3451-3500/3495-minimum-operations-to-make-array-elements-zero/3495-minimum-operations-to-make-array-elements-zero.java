// https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/

// Solution: Level Buckets with Total Steps — O(Q * log(max)) time, O(1) space
class Solution {
    public long minOperations(int[][] queries) {
        long total = 0;
        for (int[] query : queries) {
            long l = query[0];
            long r = query[1];
            long steps = 0;
            long lo = 1, hi = 3;
            int level = 1;
            while (lo <= r) {
                long overlapL = Math.max(l, lo);
                long overlapR = Math.min(r, hi);
                if (overlapL <= overlapR) {
                    steps += (overlapR - overlapL + 1) * level;
                }
                lo = hi + 1;
                hi = hi * 4 + 3;
                level++;
            }
            total += (steps + 1) / 2;
        }
        return total;
    }
}
