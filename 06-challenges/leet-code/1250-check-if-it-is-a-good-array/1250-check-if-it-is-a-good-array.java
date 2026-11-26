// https://leetcode.com/problems/check-if-it-is-a-good-array/

// Solution: GCD (Bezout's Identity) — O(n log max) time, O(1) space
// Solution: GCD (Bezout's Identity) — O(n log max) time, O(1) space
class Solution {
    public boolean isGoodArray(int[] nums) {
        int g = nums[0];
        for (int x : nums) g = gcd(g, x);
        return g == 1;
    }
    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
}
