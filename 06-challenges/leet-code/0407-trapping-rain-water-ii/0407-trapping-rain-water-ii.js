// https://leetcode.com/problems/trapping-rain-water-ii/

var trapRainWater = function(heightMap) {
    const m = heightMap.length, n = heightMap[0].length;
    if (m < 3 || n < 3) return 0;
    const visited = Array.from({length: m}, () => new Array(n).fill(false));
    // Min-heap via sorted array (simple for bounded grid)
    const heap = [];
    const push = (val) => {
        heap.push(val);
        heap.sort((a, b) => a[0] - b[0]);
    };
    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (r === 0 || r === m - 1 || c === 0 || c === n - 1) {
                push([heightMap[r][c], r, c]);
                visited[r][c] = true;
            }
        }
    }
    let water = 0;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    while (heap.length > 0) {
        const [level, r, c] = heap.shift();
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            water += Math.max(0, level - heightMap[nr][nc]);
            push([Math.max(level, heightMap[nr][nc]), nr, nc]);
        }
    }
    return water;
};
