// https://leetcode.com/problems/sudoku-solver/

var solveSudoku = function(board) {
    const rows = new Int32Array(9), cols = new Int32Array(9), boxes = new Int32Array(9);

    for (let r = 0; r < 9; r++) {
        for (let c = 0; c < 9; c++) {
            if (board[r][c] !== '.') {
                const bit = 1 << parseInt(board[r][c]);
                rows[r] |= bit;
                cols[c] |= bit;
                boxes[Math.floor(r / 3) * 3 + Math.floor(c / 3)] |= bit;
            }
        }
    }

    function solve(pos) {
        if (pos === 81) {
            return true;
        }
        const r = Math.floor(pos / 9), c = pos % 9;
        if (board[r][c] !== '.') {
            return solve(pos + 1);
        }
        const box = Math.floor(r / 3) * 3 + Math.floor(c / 3);
        for (let d = 1; d <= 9; d++) {
            const bit = 1 << d;
            if ((rows[r] & bit) || (cols[c] & bit) || (boxes[box] & bit)) {
                continue;
            }
            board[r][c] = String(d);
            rows[r] |= bit;
            cols[c] |= bit;
            boxes[box] |= bit;
            if (solve(pos + 1)) {
                return true;
            }
            board[r][c] = '.';
            rows[r] ^= bit;
            cols[c] ^= bit;
            boxes[box] ^= bit;
        }
        return false;
    }

    solve(0);
};
