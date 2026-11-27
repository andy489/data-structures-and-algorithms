// https://leetcode.com/problems/mirror-reflection/

// Solution: Math (LCM) — O(log p) time, O(1) space
class Solution {
    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        int m = p / g;
        int n = q / g;
        if (m % 2 == 0) {
            return 2;
        }
        if (n % 2 == 0) {
            return 0;
        }
        return 1;
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
