// https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int maxOperations(int[] nums) {
        int target = nums[0] + nums[1], count = 0;
        for (int i = 0; i + 1 < nums.length && nums[i] + nums[i + 1] == target; i += 2) {
            count++;
        }
        return count;
    }
}
