// https://leetcode.com/problems/max-number-of-k-sum-pairs/

// Solution: Two Pointers on Sorted Array — O(n log n) time, O(1) space
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, count = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == k) {
                count++;
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
