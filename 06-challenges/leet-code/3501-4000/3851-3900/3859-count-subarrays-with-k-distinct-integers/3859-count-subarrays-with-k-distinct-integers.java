// https://leetcode.com/problems/count-subarrays-with-k-distinct-integers/

class Solution {
    private long atMost(int[] nums, int k, int m) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;
        int qualified = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            freq.merge(nums[r], 1, Integer::sum);
            if (freq.get(nums[r]) == m) {
                qualified++;
            }
            while (qualified > k) {
                freq.merge(nums[l], -1, Integer::sum);
                if (freq.get(nums[l]) == m - 1) {
                    qualified--;
                }
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }

    public long countSubarrays(int[] nums, int k, int m) {
        return atMost(nums, k, m) - atMost(nums, k - 1, m);
    }
}
