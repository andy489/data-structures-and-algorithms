// https://leetcode.com/problems/generate-random-point-in-a-circle/

// Solution: Polar Coordinates (Square Root Sampling) — O(1) time, O(1) space
class Solution {
    private final double radius;
    private final double xCenter;
    private final double yCenter;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    public double[] randPoint() {
        double angle = 2 * Math.PI * Math.random();
        double r = radius * Math.sqrt(Math.random());
        return new double[]{xCenter + r * Math.cos(angle), yCenter + r * Math.sin(angle)};
    }
}
