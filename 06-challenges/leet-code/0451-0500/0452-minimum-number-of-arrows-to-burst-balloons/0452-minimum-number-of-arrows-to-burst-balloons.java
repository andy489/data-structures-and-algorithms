// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

// Solution: Greedy (Sort by End) — O(n log n) time, O(1) space
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        int arrowPos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }
        return arrows;
    }
}
