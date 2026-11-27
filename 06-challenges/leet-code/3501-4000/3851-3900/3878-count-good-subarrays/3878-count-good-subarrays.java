// https://leetcode.com/problems/count-good-subarrays/

class Solution {
    public long countGoodSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        // sliding window: maintain window where OR == max
        // use a treemap to track count of each value for max queries
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int windowOr = 0;
        int left = 0;
        // We rebuild OR from scratch after shrinking — use an int array to track elements
        for (int right = 0; right < n; right++) {
            freq.merge(nums[right], 1, Integer::sum);
            windowOr |= nums[right];
            int max = freq.lastKey();
            // shrink while OR != max
            while (windowOr != max) {
                int rem = nums[left++];
                freq.merge(rem, -1, Integer::sum);
                if (freq.get(rem) == 0) {
                    freq.remove(rem);
                }
                // recompute OR from left to right
                windowOr = 0;
                for (int i = left; i <= right; i++) {
                    windowOr |= nums[i];
                }
                if (!freq.isEmpty()) {
                    max = freq.lastKey();
                }
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
