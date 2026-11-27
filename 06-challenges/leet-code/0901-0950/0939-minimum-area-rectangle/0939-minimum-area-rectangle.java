// https://leetcode.com/problems/minimum-area-rectangle/

// Solution: HashSet + Pair Enumeration — O(n²) time, O(n) space
class Solution {
    public int minAreaRect(int[][] points) {
        java.util.Set<Long> pointSet = new java.util.HashSet<>();
        for (int[] p : points) {
            pointSet.add((long) p[0] * 50001 + p[1]);
        }
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 != x2 && y1 != y2) {
                    if (pointSet.contains((long) x1 * 50001 + y2) &&
                        pointSet.contains((long) x2 * 50001 + y1)) {
                        minArea = Math.min(minArea, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                    }
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
