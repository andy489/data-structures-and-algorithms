// https://leetcode.com/problems/left-and-right-sum-differences/

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        int[] answer = new int[n];
        int left = 0;
        for (int i = 0; i < n; i++) {
            int right = total - left - nums[i];
            answer[i] = Math.abs(left - right);
            left += nums[i];
        }
        return answer;
    }
}
