// https://leetcode.com/problems/available-captures-for-rook/

var numRookCaptures = function(board) {
    let rx = 0, ry = 0;
    for (let i = 0; i < 8; i++) for (let j = 0; j < 8; j++) if (board[i][j] === 'R') { rx = i; ry = j; }
    let captures = 0;
    for (const [dr, dc] of [[0,1],[0,-1],[1,0],[-1,0]]) {
        let r = rx + dr, c = ry + dc;
        while (r >= 0 && r < 8 && c >= 0 && c < 8) {
            if (board[r][c] === 'B') break;
            if (board[r][c] === 'p') { captures++; break; }
            r += dr; c += dc;
        }
    }
    return captures;
};
