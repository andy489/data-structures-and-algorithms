// https://leetcode.com/problems/ugly-number-iii/

// Solution: Inclusion-Exclusion + Binary Search — O(log(n * min(a,b))) time, O(1) space
// Solution: Inclusion-Exclusion + Binary Search — O(log(n*min(a,b))) time, O(1) space
class Solution {
    public int nthUglyNumber(int n, int a, int b) {
        long lcm = a / gcd(a, b) * (long) b;
        long lo = 1, hi = (long) n * Math.min(a, b);
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (mid / a + mid / b - mid / lcm >= n) hi = mid;
            else lo = mid + 1;
        }
        return (int) lo;
    }
    private long gcd(long x, long y) { return y == 0 ? x : gcd(y, x % y); }
}
