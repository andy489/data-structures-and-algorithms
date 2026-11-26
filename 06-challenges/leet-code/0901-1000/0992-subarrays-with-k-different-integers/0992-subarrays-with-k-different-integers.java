// https://leetcode.com/problems/subarrays-with-k-different-integers/

// Solution: Sliding Window — O(n) time, O(n) space
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0, lo = 0;
        for (int hi = 0; hi < nums.length; hi++) {
            count.merge(nums[hi], 1, Integer::sum);
            while (count.size() > k) {
                count.merge(nums[lo], -1, Integer::sum);
                if (count.get(nums[lo]) == 0) { count.remove(nums[lo]); }
                lo++;
            }
            res += hi - lo + 1;
        }
        return res;
    }
}
