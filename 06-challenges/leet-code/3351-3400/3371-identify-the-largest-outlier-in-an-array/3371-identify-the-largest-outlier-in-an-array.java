// https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/

// Solution: Frequency Map + Total Sum — O(n) time, O(n) space
class Solution {
    public int getLargestOutlier(int[] nums) {
        int total = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            total += x;
            freq.merge(x, 1, Integer::sum);
        }
        int ans = Integer.MIN_VALUE;
        for (int x : nums) {
            int remainder = total - x;
            if (remainder % 2 != 0) {
                continue;
            }
            int need = remainder / 2;
            freq.merge(x, -1, Integer::sum);
            if (freq.getOrDefault(need, 0) > 0) {
                ans = Math.max(ans, x);
            }
            freq.merge(x, 1, Integer::sum);
        }
        return ans;
    }
}
