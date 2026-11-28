// https://leetcode.com/problems/separate-black-and-white-balls/

// Solution: Greedy Two-Pointer Count — O(n) time, O(1) space
class Solution {
    public long minimumSteps(String s) {
        long moves = 0;
        int whites = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                whites++;
            } else {
                moves += whites;
            }
        }
        return moves;
    }
}
