// https://leetcode.com/problems/frequency-of-the-most-frequent-element/

// Solution: Sort + Sliding Window — O(n log n) time, O(1) space
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, ans = 1;
        long windowSum = 0;
        for (int r = 0; r < nums.length; r++) {
            windowSum += nums[r];
            while ((long) nums[r] * (r - l + 1) - windowSum > k) {
                windowSum -= nums[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
