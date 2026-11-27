// https://leetcode.com/problems/jump-game-ii/

// Solution: Greedy — O(n) time, O(1) space
// Scan in "levels": curEnd is the last index reachable with jumps so far.
// When we reach curEnd we must jump; the next level ends at farthest.
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == curEnd) {       // exhausted current jump's range: must jump
                jumps++;
                curEnd = farthest;
                if (curEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}
