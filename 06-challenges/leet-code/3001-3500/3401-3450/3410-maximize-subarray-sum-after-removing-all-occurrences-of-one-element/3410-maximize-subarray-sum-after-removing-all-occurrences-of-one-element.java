// https://leetcode.com/problems/maximize-subarray-sum-after-removing-all-occurrences-of-one-element/
class Solution {
    public long maximumSumSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> negatives = new HashSet<>();
        for (int x : nums) {
            if (x < 0) {
                negatives.add(x);
            }
        }

        long ans = kadane(nums, Integer.MAX_VALUE);  // no removal
        for (int x : negatives) {
            ans = Math.max(ans, kadane(nums, x));
        }
        return ans;
    }

    private long kadane(int[] nums, int skip) {
        long cur = 0, best = Long.MIN_VALUE;
        for (int v : nums) {
            if (v == skip) {
                continue;
            }
            cur += v;
            best = Math.max(best, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return best == Long.MIN_VALUE ? Long.MIN_VALUE : best;
    }
}
