// https://leetcode.com/problems/powx-n/

// Solution: Recursive fast exponentiation — O(log n) time, O(log n) space
class Solution {
    public double myPow(double x, int n) {
        return fastPow(x, (long) n);
    }

    private double fastPow(double x, long n) {
        if (n < 0) {
            return 1.0 / fastPow(x, -n);
        }
        if (n == 0) {
            return 1.0;
        }
        if (n % 2 == 0) {
            return fastPow(x * x, n / 2);
        }
        return x * fastPow(x * x, n / 2);
    }
}

// Solution2: Iterative fast exponentiation — O(log n) time, O(1) space
class Solution2 {
    public double myPow(double x, int n) {
        long p = (long) n;
        if (p < 0) {
            x = 1.0 / x;
            p = -p;
        }
        double result = 1.0;
        while (p > 0) {
            if ((p & 1) == 1) {
                result *= x;
            }
            x *= x;
            p >>= 1;
        }
        return result;
    }
}
