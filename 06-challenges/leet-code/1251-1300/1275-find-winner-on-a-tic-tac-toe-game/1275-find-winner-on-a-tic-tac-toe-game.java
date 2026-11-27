// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

// Solution: Score Arrays — O(1) time, O(1) space
// Solution: Score Arrays — O(1) time, O(1) space
class Solution {
    public String tictactoe(int[][] moves) {
        int[] row = new int[3], col = new int[3];
        int diag = 0, anti = 0;
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0], c = moves[i][1], v = i % 2 == 0 ? 1 : -1;
            row[r] += v; col[c] += v;
            if (r == c) diag += v;
            if (r + c == 2) anti += v;
        }
        for (int i = 0; i < 3; i++) {
            if (Math.abs(row[i]) == 3 || Math.abs(col[i]) == 3) return moves.length % 2 == 0 ? "B" : "A";
        }
        if (Math.abs(diag) == 3 || Math.abs(anti) == 3) return moves.length % 2 == 0 ? "B" : "A";
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
