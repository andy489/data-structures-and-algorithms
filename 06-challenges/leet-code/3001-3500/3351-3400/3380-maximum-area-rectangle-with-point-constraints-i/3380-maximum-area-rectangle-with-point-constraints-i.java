// https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-i/

// Solution: Brute Force with Point Check — O(n^2 * n) time, O(n) space
class Solution {
    public long maxRectangleArea(int[][] points) {
        int n = points.length;
        java.util.Set<String> ptSet = new java.util.HashSet<>();
        for (int[] p : points) {
            ptSet.add(p[0] + "," + p[1]);
        }

        long maxArea = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = Math.min(points[i][0], points[j][0]);
                int x2 = Math.max(points[i][0], points[j][0]);
                int y1 = Math.min(points[i][1], points[j][1]);
                int y2 = Math.max(points[i][1], points[j][1]);
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                // Check all 4 corners exist
                if (!ptSet.contains(x1 + "," + y1) || !ptSet.contains(x1 + "," + y2)
                        || !ptSet.contains(x2 + "," + y1) || !ptSet.contains(x2 + "," + y2)) {
                    continue;
                }
                // Check no other point inside or on border
                boolean valid = true;
                for (int[] p : points) {
                    if (p[0] >= x1 && p[0] <= x2 && p[1] >= y1 && p[1] <= y2) {
                        // it's a corner — allowed
                        if ((p[0] == x1 || p[0] == x2) && (p[1] == y1 || p[1] == y2)) {
                            continue;
                        }
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    maxArea = Math.max(maxArea, (long) (x2 - x1) * (y2 - y1));
                }
            }
        }
        return maxArea;
    }
}
