// https://leetcode.com/problems/chalkboard-xor-game/

// Solution: Math Insight — O(n) time, O(1) space
class Solution {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int x : nums) {
            xor ^= x;
        }
        return xor == 0 || nums.length % 2 == 0;
    }
}
