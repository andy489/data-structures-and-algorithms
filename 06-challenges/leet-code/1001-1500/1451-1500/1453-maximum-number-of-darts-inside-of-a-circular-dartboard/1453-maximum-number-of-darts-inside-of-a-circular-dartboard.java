// https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/

// Solution: O(n^3) Geometry — O(n^3) time, O(1) space
class Solution {
    public int numPoints(int[][] darts, int r) {
        int n = darts.length, ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                double[] c1 = circle(darts[i], darts[j], r, 1);
                double[] c2 = circle(darts[i], darts[j], r, -1);
                if (c1 != null) ans = Math.max(ans, count(darts, c1, r));
                if (c2 != null) ans = Math.max(ans, count(darts, c2, r));
            }
        }
        return ans;
    }
    private double[] circle(int[] a, int[] b, int r, int sign) {
        double mx = (a[0]+b[0])/2.0, my = (a[1]+b[1])/2.0;
        double dx = b[0]-a[0], dy = b[1]-a[1];
        double d = Math.sqrt(dx*dx+dy*dy);
        if (d > 2*r) return null;
        double h = Math.sqrt(r*r - d*d/4);
        return new double[]{mx + sign*h*(-dy/d), my + sign*h*(dx/d)};
    }
    private int count(int[][] darts, double[] c, int r) {
        int cnt = 0;
        for (int[] d : darts) {
            double dx = d[0]-c[0], dy = d[1]-c[1];
            if (dx*dx+dy*dy <= r*(double)r+1e-6) cnt++;
        }
        return cnt;
    }
}
