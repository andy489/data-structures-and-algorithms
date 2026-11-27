// https://leetcode.com/problems/transform-to-chessboard/

var movesToChessboard = function(board) {
    const n = board.length;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) !== 0) return -1;
        }
    }
    let rowSum = 0, colSum = 0, rowMis = 0, colMis = 0;
    for (let i = 0; i < n; i++) {
        rowSum += board[0][i];
        colSum += board[i][0];
        if (board[i][0] === i % 2) rowMis++;
        if (board[0][i] === i % 2) colMis++;
    }
    if (rowSum < Math.floor(n/2) || rowSum > Math.ceil(n/2)) return -1;
    if (colSum < Math.floor(n/2) || colSum > Math.ceil(n/2)) return -1;
    if (n % 2 === 1) {
        if (rowMis % 2 === 1) rowMis = n - rowMis;
        if (colMis % 2 === 1) colMis = n - colMis;
    } else {
        rowMis = Math.min(rowMis, n - rowMis);
        colMis = Math.min(colMis, n - colMis);
    }
    return (rowMis + colMis) / 2;
};
