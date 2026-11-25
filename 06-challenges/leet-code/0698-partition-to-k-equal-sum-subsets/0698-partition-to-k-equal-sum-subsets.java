// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

// Solution: Backtracking — O(k·2^n) time, O(n) space
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        if (total % k != 0) {
            return false;
        }
        int target = total / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        int[] buckets = new int[k];
        return backtrack(nums, buckets, nums.length - 1, target);
    }

    private boolean backtrack(int[] nums, int[] buckets, int idx, int target) {
        if (idx < 0) {
            return true;
        }
        boolean[] tried = new boolean[target + 1];
        for (int i = 0; i < buckets.length; i++) {
            if (tried[buckets[i]]) {
                continue;
            }
            if (buckets[i] + nums[idx] <= target) {
                tried[buckets[i]] = true;
                buckets[i] += nums[idx];
                if (backtrack(nums, buckets, idx - 1, target)) {
                    return true;
                }
                buckets[i] -= nums[idx];
            }
        }
        return false;
    }
}
