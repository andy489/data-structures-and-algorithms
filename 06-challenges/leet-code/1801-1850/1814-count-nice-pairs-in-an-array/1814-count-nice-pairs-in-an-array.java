// https://leetcode.com/problems/count-nice-pairs-in-an-array/

// Solution: Group by (num - rev(num)) — O(n log n) time, O(n) space
class Solution {
    private int rev(int x) {
        int r = 0;
        while (x > 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Long> freq = new HashMap<>();
        for (int x : nums) {
            freq.merge(x - rev(x), 1L, Long::sum);
        }
        long ans = 0, mod = 1_000_000_007L;
        for (long cnt : freq.values()) {
            ans = (ans + cnt * (cnt - 1) / 2) % mod;
        }
        return (int) ans;
    }
}
