// https://leetcode.com/problems/count-lattice-points-inside-a-circle/

class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<Integer> seen = new HashSet<>();
        for (int[] c : circles) {
            int cx = c[0], cy = c[1], r = c[2];
            for (int x = cx - r; x <= cx + r; x++) {
                for (int y = cy - r; y <= cy + r; y++) {
                    int dx = x - cx, dy = y - cy;
                    if (dx * dx + dy * dy <= r * r) {
                        seen.add(x * 201 + y);
                    }
                }
            }
        }
        return seen.size();
    }
}
