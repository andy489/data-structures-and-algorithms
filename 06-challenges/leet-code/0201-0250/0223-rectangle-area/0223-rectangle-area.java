// https://leetcode.com/problems/rectangle-area/

// Solution: Area Formula — O(1) time, O(1) space
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);
        int overlapW = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapH = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return areaA + areaB - overlapW * overlapH;
    }
}
