// https://leetcode.com/problems/map-of-highest-peak/

var highestPeak = function(isWater) {
    const m = isWater.length, n = isWater[0].length;
    const height = Array.from({length: m}, () => new Array(n).fill(-1));
    const queue = [];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (isWater[i][j] === 1) {
                height[i][j] = 0;
                queue.push([i, j]);
            }
        }
    }
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    let head = 0;
    while (head < queue.length) {
        const [r, c] = queue[head++];
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && height[nr][nc] === -1) {
                height[nr][nc] = height[r][c] + 1;
                queue.push([nr, nc]);
            }
        }
    }
    return height;
};
