// https://leetcode.com/problems/magic-squares-in-grid/

var numMagicSquaresInside = function(grid) {
    const rows = grid.length, cols = grid[0].length;
    function isMagic(r, c) {
        const seen = new Set();
        for (let i = r; i < r+3; i++) for (let j = c; j < c+3; j++) {
            const v = grid[i][j];
            if (v < 1 || v > 9 || seen.has(v)) { return false; }
            seen.add(v);
        }
        for (let i = r; i < r+3; i++) {
            if (grid[i][c]+grid[i][c+1]+grid[i][c+2] !== 15) { return false; }
        }
        for (let j = c; j < c+3; j++) {
            if (grid[r][j]+grid[r+1][j]+grid[r+2][j] !== 15) { return false; }
        }
        if (grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2] !== 15) { return false; }
        if (grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c] !== 15) { return false; }
        return true;
    }
    let count = 0;
    for (let r = 0; r <= rows-3; r++) for (let c = 0; c <= cols-3; c++) if (isMagic(r,c)) count++;
    return count;
};
