// https://leetcode.com/problems/minesweeper/

var updateBoard = function(board, click) {
    const DIRS = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]];
    const m = board.length, n = board[0].length;
    const [startR, startC] = click;

    if (board[startR][startC] === 'M') {
        board[startR][startC] = 'X';
        return board;
    }

    function dfs(r, c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] !== 'E') { return; }
        let mines = 0;
        for (const [dr, dc] of DIRS) {
            const nr = r + dr, nc = c + dc;
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] === 'M') { mines++; }
        }
        if (mines > 0) {
            board[r][c] = String(mines);
        } else {
            board[r][c] = 'B';
            for (const [dr, dc] of DIRS) { dfs(r + dr, c + dc); }
        }
    }

    dfs(startR, startC);
    return board;
};
