// https://leetcode.com/problems/determine-color-of-a-chessboard-square/

// Solution: Parity Check — O(1) time, O(1) space
class Solution {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '1') % 2 == 1;
    }
}
