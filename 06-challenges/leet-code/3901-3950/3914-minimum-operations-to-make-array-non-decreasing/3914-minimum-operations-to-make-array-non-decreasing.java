// https://leetcode.com/problems/minimum-operations-to-make-array-non-decreasing/
class Solution {
    public long minimumOperations(int[] nums) {
        // The minimum total x equals sum of drops: for each i where nums[i] > nums[i+1],
        // we need to increase nums[i+1] by at least nums[i]-nums[i+1].
        // This translates to sum of max(0, prev - current) for each consecutive pair.
        long total = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                total += (long)(nums[i] - nums[i + 1]);
            }
        }
        return total;
    }
}
