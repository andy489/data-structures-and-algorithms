// https://leetcode.com/problems/perfect-rectangle/

// Solution: Area + Corner Set — O(n) time, O(n) space
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> corners = new HashSet<>();
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        long area = 0;

        for (int[] r : rectangles) {
            x1 = Math.min(x1, r[0]);
            y1 = Math.min(y1, r[1]);
            x2 = Math.max(x2, r[2]);
            y2 = Math.max(y2, r[3]);
            area += (long)(r[2] - r[0]) * (r[3] - r[1]);

            String[] pts = {r[0]+","+r[1], r[0]+","+r[3], r[2]+","+r[1], r[2]+","+r[3]};
            for (String p : pts) {
                if (!corners.add(p)) {
                    corners.remove(p);
                }
            }
        }

        if (corners.size() != 4) {
            return false;
        }
        if (!corners.contains(x1+","+y1) || !corners.contains(x1+","+y2) ||
            !corners.contains(x2+","+y1) || !corners.contains(x2+","+y2)) {
            return false;
        }
        return area == (long)(x2 - x1) * (y2 - y1);
    }
}
