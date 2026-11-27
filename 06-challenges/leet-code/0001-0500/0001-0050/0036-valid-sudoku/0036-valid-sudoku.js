// https://leetcode.com/problems/valid-sudoku/

// Solution: Single-pass with index-encoded sets — O(1) time, O(1) space
var isValidSudoku = function(board) {
    const rows  = new Int32Array(9);
    const cols  = new Int32Array(9);
    const boxes = new Int32Array(9);
    for (let r = 0; r < 9; r++) {
        for (let c = 0; c < 9; c++) {
            if (board[r][c] === '.') {
                continue;
            }
            const bit = 1 << Number(board[r][c]);
            const box = Math.floor(r / 3) * 3 + Math.floor(c / 3);
            if ((rows[r] & bit) || (cols[c] & bit) || (boxes[box] & bit)) {
                return false;
            }
            rows[r]    |= bit;
            cols[c]    |= bit;
            boxes[box] |= bit;
        }
    }
    return true;
};
