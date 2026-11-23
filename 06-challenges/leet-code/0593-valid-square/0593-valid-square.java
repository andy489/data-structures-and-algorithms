// https://leetcode.com/problems/valid-square/
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Long> distances = new HashSet<>();
        int[][] points = {p1, p2, p3, p4};
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                long dist = squaredDist(points[i], points[j]);
                if (dist == 0) {
                    return false;
                }
                distances.add(dist);
            }
        }
        return distances.size() == 2;
    }

    private long squaredDist(int[] a, int[] b) {
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}
