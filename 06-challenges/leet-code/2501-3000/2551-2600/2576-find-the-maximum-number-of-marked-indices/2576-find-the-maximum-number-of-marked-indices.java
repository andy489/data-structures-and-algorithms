// https://leetcode.com/problems/find-the-maximum-number-of-marked-indices/

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n / 2;
        int count = 0;
        while (right < n) {
            if (2 * nums[left] <= nums[right]) {
                count++;
                left++;
            }
            right++;
        }
        return count * 2;
    }
}
