// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/

// Solution: HashMap + Squaring Chain — O(n log(max)) time, O(n) space
class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for (int x : nums) { freq.merge((long) x, 1, Integer::sum); }
        int ans = 1;
        // Handle x=1 separately
        if (freq.containsKey(1L)) {
            int f = freq.get(1L);
            ans = f % 2 == 0 ? f - 1 : f;
        }
        for (long x : freq.keySet()) {
            if (x == 1) { continue; }
            // Only start chains from non-squares
            long sq = (long) Math.round(Math.sqrt(x));
            if (sq * sq == x && freq.containsKey(sq) && freq.get(sq) >= 2) { continue; }
            int len = 0;
            long cur = x;
            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;
                cur = cur * cur;
            }
            if (freq.getOrDefault(cur, 0) >= 1) { len++; }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
