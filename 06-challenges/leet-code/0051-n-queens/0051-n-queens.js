// https://leetcode.com/problems/n-queens/

// Solution 1: Backtracking with Sets — O(n!) time, O(n²) space
var solveNQueens = function(n) {
    const res = [];
    const queens = [];
    const cols = new Set(), diag1 = new Set(), diag2 = new Set();

    function backtrack(row) {
        if (row === n) {
            const board = queens.map(c => '.'.repeat(c) + 'Q' + '.'.repeat(n - c - 1));
            res.push(board);
            return;
        }
        for (let col = 0; col < n; col++) {
            if (cols.has(col) || diag1.has(row - col) || diag2.has(row + col)) continue;
            queens.push(col);
            cols.add(col); diag1.add(row - col); diag2.add(row + col);
            backtrack(row + 1);
            queens.pop();
            cols.delete(col); diag1.delete(row - col); diag2.delete(row + col);
        }
    }

    backtrack(0);
    return res;
};

// Solution 2: Backtracking with Bitmasks — O(n!) time, O(n²) space
var solveNQueens2 = function(n) {
    const res = [];
    const queens = new Array(n).fill(0);
    const fullMask = (1 << n) - 1;

    function backtrack(row, cols, diag1, diag2) {
        if (row === n) {
            const board = queens.map(c => '.'.repeat(c) + 'Q' + '.'.repeat(n - c - 1));
            res.push(board);
            return;
        }
        let available = ~(cols | diag1 | diag2) & fullMask;
        while (available) {
            const bit = available & -available;
            queens[row] = Math.log2(bit);
            backtrack(row + 1, cols | bit, (diag1 | bit) >> 1, (diag2 | bit) << 1);
            available &= available - 1;
        }
    }

    backtrack(0, 0, 0, 0);
    return res;
};
