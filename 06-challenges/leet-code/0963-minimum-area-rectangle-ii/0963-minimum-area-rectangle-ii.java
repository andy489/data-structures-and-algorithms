// https://leetcode.com/problems/minimum-area-rectangle-ii/

// Solution: Enumerate Diagonals — O(n²) average time, O(n²) space
class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Set<String> pointSet = new HashSet<>();
        for (int[] p : points) { pointSet.add(p[0] + "," + p[1]); }
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] A = points[i], B = points[j], C = points[k];
                    // Check if (A,B,C) can form 3 corners of a rectangle
                    // Try A as right angle vertex
                    if (isRightAngle(A, B, C)) {
                        int dx = B[0] + C[0] - A[0], dy = B[1] + C[1] - A[1];
                        if (pointSet.contains(dx + "," + dy)) {
                            double area = dist(A, B) * dist(A, C);
                            ans = Math.min(ans, area);
                        }
                    }
                    if (isRightAngle(B, A, C)) {
                        int dx = A[0] + C[0] - B[0], dy = A[1] + C[1] - B[1];
                        if (pointSet.contains(dx + "," + dy)) {
                            double area = dist(B, A) * dist(B, C);
                            ans = Math.min(ans, area);
                        }
                    }
                    if (isRightAngle(C, A, B)) {
                        int dx = A[0] + B[0] - C[0], dy = A[1] + B[1] - C[1];
                        if (pointSet.contains(dx + "," + dy)) {
                            double area = dist(C, A) * dist(C, B);
                            ans = Math.min(ans, area);
                        }
                    }
                }
            }
        }
        return ans == Double.MAX_VALUE ? 0 : ans;
    }

    private boolean isRightAngle(int[] vertex, int[] p1, int[] p2) {
        return (p1[0]-vertex[0])*(p2[0]-vertex[0]) + (p1[1]-vertex[1])*(p2[1]-vertex[1]) == 0;
    }

    private double dist(int[] a, int[] b) {
        int dx = a[0]-b[0], dy = a[1]-b[1];
        return Math.sqrt(dx*dx + dy*dy);
    }
}
