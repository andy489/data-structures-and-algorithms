// https://leetcode.com/problems/game-of-life/

// Solution: In-Place with Encoded States — O(m·n) time, O(1) space
var gameOfLife = function(board) {
    const m = board.length, n = board[0].length;
    const dirs = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]];
    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            let live = 0;
            for (const [dr, dc] of dirs) {
                const nr = r + dr, nc = c + dc;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && Math.abs(board[nr][nc]) === 1) {
                    live++;
                }
            }
            if (board[r][c] === 1 && (live < 2 || live > 3)) {
                board[r][c] = -1;
            } else if (board[r][c] === 0 && live === 3) {
                board[r][c] = 2;
            }
        }
    }
    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (board[r][c] === -1) board[r][c] = 0;
            else if (board[r][c] === 2) board[r][c] = 1;
        }
    }
};
