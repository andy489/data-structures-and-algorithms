// https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/

// Solution: Weighted Sampling with Prefix Sums — O(log n) per pick, O(n) space
class Solution {
    private int[][] rects;
    private int[] prefixSums;
    private int totalPoints;
    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSums = new int[rects.length];
        this.random = new Random();
        int cumulative = 0;
        for (int i = 0; i < rects.length; i++) {
            cumulative += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            prefixSums[i] = cumulative;
        }
        this.totalPoints = cumulative;
    }

    public int[] pick() {
        int target = random.nextInt(totalPoints);
        int lo = 0, hi = rects.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefixSums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int[] rect = rects[lo];
        int width = rect[2] - rect[0] + 1;
        int offset = target - (lo > 0 ? prefixSums[lo - 1] : 0);
        return new int[]{rect[0] + offset % width, rect[1] + offset / width};
    }
}
