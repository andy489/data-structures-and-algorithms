// https://leetcode.com/problems/best-position-for-a-service-centre/

// Solution: Gradient Descent (Weiszfeld's Algorithm) — O(n * iterations) time, O(1) space
class Solution {
    public double getMinDistSum(int[][] positions) {
        double x = 0, y = 0;
        int n = positions.length;
        for (int[] p : positions) {
            x += p[0];
            y += p[1];
        }
        x /= n;
        y /= n;

        double step = 1.0;
        while (step > 1e-6) {
            double nx = 0, ny = 0, totalW = 0;
            for (int[] p : positions) {
                double d = Math.sqrt((x - p[0]) * (x - p[0]) + (y - p[1]) * (y - p[1]));
                if (d < 1e-9) {
                    continue;
                }
                double w = 1.0 / d;
                nx += w * p[0];
                ny += w * p[1];
                totalW += w;
            }
            if (totalW < 1e-9) {
                break;
            }
            nx /= totalW;
            ny /= totalW;
            if (dist(nx, ny, positions) >= dist(x, y, positions)) {
                step *= 0.5;
            } else {
                x = nx;
                y = ny;
            }
        }
        return dist(x, y, positions);
    }

    private double dist(double x, double y, int[][] positions) {
        double s = 0;
        for (int[] p : positions) {
            s += Math.sqrt((x - p[0]) * (x - p[0]) + (y - p[1]) * (y - p[1]));
        }
        return s;
    }
}
