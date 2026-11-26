// https://leetcode.com/problems/n-queens-ii/

// Solution 1: Backtracking with Bitmasks — O(n!) time, O(n) space
var totalNQueens = function(n) {
    const fullMask = (1 << n) - 1;

    function backtrack(cols, diag1, diag2) {
        if (cols === fullMask) return 1;
        let count = 0;
        let available = ~(cols | diag1 | diag2) & fullMask;
        while (available) {
            const bit = available & -available;
            count += backtrack(cols | bit, (diag1 | bit) >> 1, (diag2 | bit) << 1);
            available &= available - 1;
        }
        return count;
    }

    return backtrack(0, 0, 0);
};

// Solution 2: Backtracking with Sets — O(n!) time, O(n) space
var totalNQueens2 = function(n) {
    const cols = new Set(), diag1 = new Set(), diag2 = new Set();

    function backtrack(row) {
        if (row === n) return 1;
        let count = 0;
        for (let col = 0; col < n; col++) {
            if (cols.has(col) || diag1.has(row - col) || diag2.has(row + col)) continue;
            cols.add(col); diag1.add(row - col); diag2.add(row + col);
            count += backtrack(row + 1);
            cols.delete(col); diag1.delete(row - col); diag2.delete(row + col);
        }
        return count;
    }

    return backtrack(0);
};
