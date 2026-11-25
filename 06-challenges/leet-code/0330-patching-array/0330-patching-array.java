// https://leetcode.com/problems/patching-array/

// Solution: Greedy Range Extension — O(m + log n) time, O(1) space
class Solution {
    public int minPatches(int[] nums, int n) {
        long reach = 0;
        int patches = 0, i = 0;
        while (reach < n) {
            if (i < nums.length && nums[i] <= reach + 1) {
                reach += nums[i++];
            } else {
                reach += reach + 1;
                patches++;
            }
        }
        return patches;
    }
}
