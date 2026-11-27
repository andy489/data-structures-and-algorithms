// https://leetcode.com/problems/cat-and-mouse-ii/

var canMouseWin = function(grid, catJump, mouseJump) {
    const rows = grid.length, cols = grid[0].length;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    let mr = 0, mc = 0, cr = 0, cc = 0, fr = 0, fc = 0;
    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if (grid[i][j] === 'M') { mr = i; mc = j; }
            else if (grid[i][j] === 'C') { cr = i; cc = j; }
            else if (grid[i][j] === 'F') { fr = i; fc = j; }
        }
    }

    const memo = new Map();

    const solve = (mr, mc, cr, cc, turn) => {
        if (turn === 128) { return false; }
        if (mr === cr && mc === cc) { return false; }
        if (mr === fr && mc === fc) { return true; }
        const key = `${mr},${mc},${cr},${cc},${turn}`;
        if (memo.has(key)) { return memo.get(key); }

        let result;
        if (turn % 2 === 0) {
            result = false;
            outer: for (const [dr, dc] of dirs) {
                for (let jump = 0; jump <= mouseJump; jump++) {
                    const nr = mr + dr * jump, nc = mc + dc * jump;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] === '#') { break; }
                    if (solve(nr, nc, cr, cc, turn + 1)) { result = true; break outer; }
                }
            }
        } else {
            result = true;
            outer: for (const [dr, dc] of dirs) {
                for (let jump = 0; jump <= catJump; jump++) {
                    const nr = cr + dr * jump, nc = cc + dc * jump;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] === '#') { break; }
                    if (!solve(mr, mc, nr, nc, turn + 1)) { result = false; break outer; }
                }
            }
        }
        memo.set(key, result);
        return result;
    };

    return solve(mr, mc, cr, cc, 0);
};
