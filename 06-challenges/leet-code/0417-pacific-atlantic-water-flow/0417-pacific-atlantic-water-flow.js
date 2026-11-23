// https://leetcode.com/problems/pacific-atlantic-water-flow/

var pacificAtlantic = function(heights) {
    const m = heights.length, n = heights[0].length;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];

    function bfs(seeds) {
        const visited = Array.from({length: m}, () => new Array(n).fill(false));
        const queue = [...seeds];
        for (const [r, c] of seeds) { visited[r][c] = true; }
        let head = 0;
        while (head < queue.length) {
            const [r, c] = queue[head++];
            for (const [dr, dc] of dirs) {
                const nr = r + dr, nc = c + dc;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    visited[nr][nc] = true;
                    queue.push([nr, nc]);
                }
            }
        }
        return visited;
    }

    const pacificSeeds = [], atlanticSeeds = [];
    for (let r = 0; r < m; r++) {
        pacificSeeds.push([r, 0]);
        atlanticSeeds.push([r, n - 1]);
    }
    for (let c = 0; c < n; c++) {
        pacificSeeds.push([0, c]);
        atlanticSeeds.push([m - 1, c]);
    }

    const pacific = bfs(pacificSeeds);
    const atlantic = bfs(atlanticSeeds);

    const result = [];
    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (pacific[r][c] && atlantic[r][c]) { result.push([r, c]); }
        }
    }
    return result;
};
