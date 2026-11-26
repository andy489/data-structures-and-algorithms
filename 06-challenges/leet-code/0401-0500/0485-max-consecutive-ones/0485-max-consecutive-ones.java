// https://leetcode.com/problems/max-consecutive-ones/

// Solution: Single Pass — O(N) time, O(1) space
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 1) {
                current++;
                maxCount = Math.max(maxCount, current);
            } else {
                current = 0;
            }
        }
        return maxCount;
    }
}
