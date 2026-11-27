// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

// Solution: Prefix Sums — O(n) time, O(n) space
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = prefix[i];
            int rightSum = prefix[n] - prefix[i + 1];
            result[i] = nums[i] * i - leftSum + rightSum - nums[i] * (n - 1 - i);
        }
        return result;
    }
}
