// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

// Solution: Sort X-Coordinates — O(n log n) time, O(n) space
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xs = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xs[i] = points[i][0];
        }
        Arrays.sort(xs);
        int max = 0;
        for (int i = 1; i < xs.length; i++) {
            max = Math.max(max, xs[i] - xs[i - 1]);
        }
        return max;
    }
}
