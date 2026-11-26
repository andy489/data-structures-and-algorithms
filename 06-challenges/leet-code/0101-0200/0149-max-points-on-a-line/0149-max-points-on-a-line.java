// https://leetcode.com/problems/max-points-on-a-line/

// Solution: Slope HashMap per anchor — O(n^2) time, O(n) space
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int result = 2;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int localMax = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int g = gcd(Math.abs(dx), Math.abs(dy));
                if (g != 0) { dx /= g; dy /= g; }
                if (dx < 0) { dx = -dx; dy = -dy; }
                else if (dx == 0) dy = Math.abs(dy);
                String key = dx + "," + dy;
                int cnt = slopeCount.merge(key, 1, Integer::sum);
                localMax = Math.max(localMax, cnt);
            }
            result = Math.max(result, localMax + 1);
        }
        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
