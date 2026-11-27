// https://leetcode.com/problems/where-will-the-ball-fall/

var findBall = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    const result = new Array(n);
    for (let j = 0; j < n; j++) {
        let col = j;
        for (let row = 0; row < m; row++) {
            const dir = grid[row][col];
            const next = col + dir;
            if (next < 0 || next >= n || grid[row][next] !== dir) {
                col = -1;
                break;
            }
            col = next;
        }
        result[j] = col;
    }
    return result;
};
