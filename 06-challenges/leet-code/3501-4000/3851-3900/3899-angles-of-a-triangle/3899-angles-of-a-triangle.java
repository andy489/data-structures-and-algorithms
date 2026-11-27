// https://leetcode.com/problems/angles-of-a-triangle/
class Solution {
    public double[] anglesOfTriangle(int[] sides) {
        long a = sides[0], b = sides[1], c = sides[2];
        // Check triangle inequality (positive area)
        if (a + b <= c || a + c <= b || b + c <= a) {
            return new double[]{};
        }

        // Law of cosines: cos(A) = (b^2 + c^2 - a^2) / (2*b*c)
        double angleA = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2.0 * b * c)));
        double angleB = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2.0 * a * c)));
        double angleC = 180.0 - angleA - angleB;

        double[] result = {angleA, angleB, angleC};
        Arrays.sort(result);
        return result;
    }
}
