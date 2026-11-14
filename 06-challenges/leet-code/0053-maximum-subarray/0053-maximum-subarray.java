// https://leetcode.com/problems/maximum-subarray/

// Solution: Kadane's Algorithm — O(n) time, O(1) space
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }
}

// Solution 2: Divide and Conquer — O(n log n) time, O(log n) space
class Solution2 {
    public int maxSubArray(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private int solve(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];
        int mid = lo + (hi - lo) / 2;
        int left = solve(nums, lo, mid);
        int right = solve(nums, mid + 1, hi);
        int cross = crossMax(nums, lo, mid, hi);
        return Math.max(Math.max(left, right), cross);
    }

    private int crossMax(int[] nums, int lo, int mid, int hi) {
        int leftSum = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= lo; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= hi; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
