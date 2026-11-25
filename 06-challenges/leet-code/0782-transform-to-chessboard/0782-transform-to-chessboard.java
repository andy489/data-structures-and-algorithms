// https://leetcode.com/problems/transform-to-chessboard/

// Solution: Bit Manipulation — O(n²) time, O(1) space
class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) != 0) {
                    return -1;
                }
            }
        }
        int rowSum = 0, colSum = 0, rowMismatch = 0, colMismatch = 0;
        for (int i = 0; i < n; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] == i % 2) {
                rowMismatch++;
            }
            if (board[0][i] == i % 2) {
                colMismatch++;
            }
        }
        if (rowSum < n / 2 || rowSum > (n + 1) / 2) {
            return -1;
        }
        if (colSum < n / 2 || colSum > (n + 1) / 2) {
            return -1;
        }
        if (n % 2 == 1) {
            if (rowMismatch % 2 == 1) {
                rowMismatch = n - rowMismatch;
            }
            if (colMismatch % 2 == 1) {
                colMismatch = n - colMismatch;
            }
        } else {
            rowMismatch = Math.min(rowMismatch, n - rowMismatch);
            colMismatch = Math.min(colMismatch, n - colMismatch);
        }
        return (rowMismatch + colMismatch) / 2;
    }
}
