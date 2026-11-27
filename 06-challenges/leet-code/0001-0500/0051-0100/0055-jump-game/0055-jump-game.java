// https://leetcode.com/problems/jump-game/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}

// Solution 2: Greedy Right-to-Left — O(n) time, O(1) space
class Solution2 {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) goal = i;
        }
        return goal == 0;
    }
}
