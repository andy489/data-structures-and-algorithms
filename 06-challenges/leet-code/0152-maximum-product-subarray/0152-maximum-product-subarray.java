// https://leetcode.com/problems/maximum-product-subarray/

// Solution 1: Track max and min — O(n) time, O(1) space
class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0], curMin = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int tmpMax = Math.max(n, Math.max(curMax * n, curMin * n));
            curMin = Math.min(n, Math.min(curMax * n, curMin * n));
            curMax = tmpMax;
            result = Math.max(result, curMax);
        }
        return result;
    }
}

// Solution 2: Forward + backward pass — O(n) time, O(1) space
class Solution2 {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE, prod = 1;
        for (int n : nums) { prod *= n; result = Math.max(result, prod); if (prod == 0) prod = 1; }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) { prod *= nums[i]; result = Math.max(result, prod); if (prod == 0) prod = 1; }
        return result;
    }
}
