// https://leetcode.com/problems/water-and-jug-problem/

// Solution: Bézout's Identity (GCD) — O(log(min(x,y))) time, O(1) space
class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }
        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
