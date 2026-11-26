// https://leetcode.com/problems/circle-and-rectangle-overlapping/

// Solution: Closest Point Clamp — O(1) time, O(1) space
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int cx = Math.max(x1, Math.min(xCenter, x2));
        int cy = Math.max(y1, Math.min(yCenter, y2));
        long dx = xCenter - cx, dy = yCenter - cy;
        return dx * dx + dy * dy <= (long) radius * radius;
    }
}
