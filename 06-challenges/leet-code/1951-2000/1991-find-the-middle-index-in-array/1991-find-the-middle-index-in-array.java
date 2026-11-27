// https://leetcode.com/problems/find-the-middle-index-in-array/
class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
