// https://leetcode.com/problems/sum-of-good-numbers/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean good = true;
            if (i - k >= 0 && nums[i] <= nums[i - k]) {
                good = false;
            }
            if (i + k < n && nums[i] <= nums[i + k]) {
                good = false;
            }
            if (good) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
