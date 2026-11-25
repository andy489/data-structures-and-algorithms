// https://leetcode.com/problems/nth-magical-number/

// Solution: Binary Search + Inclusion-Exclusion — O(log(n*min(a,b))) time, O(1) space
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long MOD = 1_000_000_007L;
        long lcm = (long) a / gcd(a, b) * b;
        long lo = 1, hi = (long) n * Math.min(a, b);
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (mid / a + mid / b - mid / lcm >= n) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int) (lo % MOD);
    }

    private long gcd(long a, long b) {
        while (b != 0) { long t = b; b = a % b; a = t; }
        return a;
    }
}
