// https://leetcode.com/problems/minimum-moves-to-convert-string/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public int minimumMoves(String s) {
        int moves = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') { moves++; i += 2; }
        }
        return moves;
    }
}
