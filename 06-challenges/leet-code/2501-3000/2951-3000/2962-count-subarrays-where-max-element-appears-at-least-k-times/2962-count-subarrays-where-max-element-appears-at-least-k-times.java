// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        long ans = 0;
        int cnt = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maxVal) {
                cnt++;
            }
            while (cnt >= k) {
                if (nums[left] == maxVal) {
                    cnt--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
