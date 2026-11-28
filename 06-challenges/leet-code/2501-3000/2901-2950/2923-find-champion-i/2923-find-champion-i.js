// https://leetcode.com/problems/find-champion-i/

var findChampion = function(grid) {
    const n = grid.length;
    for (let i = 0; i < n; i++) {
        const wins = grid[i].reduce((sum, v) => sum + v, 0);
        if (wins === n - 1) {
            return i;
        }
    }
    return -1;
};
