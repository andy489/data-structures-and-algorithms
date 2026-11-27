// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

// Solution: Parity Count — O(n) time, O(1) space
// Solution: Parity Count — O(n) time, O(1) space
class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int p : position) {
            if (p % 2 == 0) even++; else odd++;
        }
        return Math.min(odd, even);
    }
}
