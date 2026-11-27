// https://leetcode.com/problems/maximum-product-of-three-numbers/

// Solution: Sort + Math — O(n log n) time, O(1) space
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int topThree = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int twoSmallest = nums[0] * nums[1] * nums[n - 1];
        return Math.max(topThree, twoSmallest);
    }
}
