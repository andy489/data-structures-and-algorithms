// https://leetcode.com/problems/house-robber-iv/

// Solution: Binary Search on Answer — O(n log(max)) time, O(1) space
class Solution {
    public int minCapability(int[] nums, int k) {
        int lo = 1, hi = 1_000_000_000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canRob(nums, k, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canRob(int[] nums, int k, int cap) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= cap) {
                count++;
                i++; // skip adjacent house
            }
        }
        return count >= k;
    }
}
