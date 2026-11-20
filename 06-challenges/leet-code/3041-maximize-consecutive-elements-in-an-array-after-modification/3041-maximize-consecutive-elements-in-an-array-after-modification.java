// https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/

// Solution: Sort + DP — O(n log n) time, O(n) space
class Solution {
    public int maximumSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int x : nums) {
            dp.put(x + 1, dp.getOrDefault(x, 0) + 1);
            dp.put(x, dp.getOrDefault(x - 1, 0) + 1);
            ans = Math.max(ans, Math.max(dp.get(x + 1), dp.get(x)));
        }
        return ans;
    }
}
