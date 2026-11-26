// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int bestDist = Integer.MAX_VALUE, bestIdx = -1;
        for (int i = 0; i < points.length; i++) {
            int a = points[i][0], b = points[i][1];
            if (a == x || b == y) {
                int dist = Math.abs(x - a) + Math.abs(y - b);
                if (dist < bestDist) {
                    bestDist = dist;
                    bestIdx = i;
                }
            }
        }
        return bestIdx;
    }
}
