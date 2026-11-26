// https://leetcode.com/problems/01-matrix/
// Solution: Multi-source BFS — O(m·n) time, O(m·n) space
var updateMatrix = function(mat) {
    const rows = mat.length;
    const cols = mat[0].length;
    const dist = Array.from({length: rows}, () => new Array(cols).fill(Infinity));
    const queue = [];
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (mat[r][c] === 0) {
                dist[r][c] = 0;
                queue.push([r, c]);
            }
        }
    }
    const dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]];
    let head = 0;
    while (head < queue.length) {
        const [r, c] = queue[head++];
        for (const [dr, dc] of dirs) {
            const nr = r + dr;
            const nc = c + dc;
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && dist[nr][nc] > dist[r][c] + 1) {
                dist[nr][nc] = dist[r][c] + 1;
                queue.push([nr, nc]);
            }
        }
    }
    return dist;
};
