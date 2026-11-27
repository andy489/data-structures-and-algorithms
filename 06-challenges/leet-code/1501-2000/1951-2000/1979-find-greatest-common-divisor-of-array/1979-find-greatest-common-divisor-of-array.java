// https://leetcode.com/problems/find-greatest-common-divisor-of-array/

// Solution: Min/Max + GCD — O(n) time, O(1) space
class Solution {
    public int findGCD(int[] nums) {
        int mn = nums[0], mx = nums[0];
        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }
        return gcd(mn, mx);
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
