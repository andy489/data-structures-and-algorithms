// https://leetcode.com/problems/stone-removal-game/

// Solution: Simulation — O(1) time, O(1) space
class Solution {
    public boolean canAliceWin(int n) {
        int toRemove = 10;
        boolean aliceTurn = true;
        while (n >= toRemove) {
            n -= toRemove;
            toRemove--;
            aliceTurn = !aliceTurn;
        }
        return !aliceTurn;
    }
}
