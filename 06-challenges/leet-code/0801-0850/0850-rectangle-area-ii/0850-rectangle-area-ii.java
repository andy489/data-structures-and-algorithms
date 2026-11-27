// https://leetcode.com/problems/rectangle-area-ii/

// Solution: Coordinate Compression + Sweep — O(n² log n) time, O(n²) space
class Solution {
    public int rectangleArea(int[][] rectangles) {
        final int MOD = 1_000_000_007;
        List<Integer> xs = new ArrayList<>();
        for (int[] r : rectangles) {
            xs.add(r[0]);
            xs.add(r[2]);
        }
        Collections.sort(xs);
        xs = new ArrayList<>(new LinkedHashSet<>(xs));
        long ans = 0;
        for (int xi = 0; xi + 1 < xs.size(); xi++) {
            int x1 = xs.get(xi), x2 = xs.get(xi + 1);
            List<int[]> intervals = new ArrayList<>();
            for (int[] r : rectangles) {
                if (r[0] <= x1 && x2 <= r[2]) {
                    intervals.add(new int[]{r[1], r[3]});
                }
            }
            intervals.sort((a, b) -> a[0] - b[0]);
            long covered = 0;
            int curStart = -1, curEnd = -1;
            for (int[] seg : intervals) {
                if (seg[0] > curEnd) {
                    covered += curEnd - curStart;
                    curStart = seg[0];
                    curEnd = seg[1];
                } else {
                    curEnd = Math.max(curEnd, seg[1]);
                }
            }
            covered += curEnd - curStart;
            ans = (ans + (long)(x2 - x1) % MOD * covered % MOD) % MOD;
        }
        return (int) ans;
    }
}
