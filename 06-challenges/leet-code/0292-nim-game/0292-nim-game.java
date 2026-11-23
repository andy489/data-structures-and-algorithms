// https://leetcode.com/problems/nim-game/

// Solution: Math — O(1) time, O(1) space
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
