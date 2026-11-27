// https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/

// Solution: HashMap of GCD-Reduced Ratios — O(n log m) time, O(n) space
class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Long> freq = new HashMap<>();
        for (int[] r : rectangles) {
            int g = gcd(r[0], r[1]);
            String key = (r[0] / g) + ":" + (r[1] / g);
            freq.merge(key, 1L, Long::sum);
        }
        long res = 0;
        for (long c : freq.values()) { res += c * (c - 1) / 2; }
        return res;
    }
    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
}
