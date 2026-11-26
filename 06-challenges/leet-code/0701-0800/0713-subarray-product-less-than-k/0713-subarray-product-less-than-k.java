// https://leetcode.com/problems/subarray-product-less-than-k/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int count = 0, product = 1, lo = 0;
        for (int hi = 0; hi < nums.length; hi++) {
            product *= nums[hi];
            while (product >= k) {
                product /= nums[lo++];
            }
            count += hi - lo + 1;
        }
        return count;
    }
}
