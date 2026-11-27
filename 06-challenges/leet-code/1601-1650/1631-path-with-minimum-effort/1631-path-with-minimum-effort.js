// https://leetcode.com/problems/path-with-minimum-effort/

var minimumEffortPath = function(heights) {
    const rows = heights.length, cols = heights[0].length;
    const effort = Array.from({length: rows}, () => new Array(cols).fill(Infinity));
    effort[0][0] = 0;
    const pq = [[0, 0, 0]]; // [effort, row, col]
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];

    while (pq.length > 0) {
        pq.sort((a, b) => a[0] - b[0]);
        const [e, r, c] = pq.shift();
        if (e > effort[r][c]) continue;
        if (r === rows - 1 && c === cols - 1) return e;
        for (const [dr, dc] of dirs) {
            const nr = r + dr, nc = c + dc;
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                const ne = Math.max(e, Math.abs(heights[nr][nc] - heights[r][c]));
                if (ne < effort[nr][nc]) {
                    effort[nr][nc] = ne;
                    pq.push([ne, nr, nc]);
                }
            }
        }
    }
    return effort[rows - 1][cols - 1];
};
