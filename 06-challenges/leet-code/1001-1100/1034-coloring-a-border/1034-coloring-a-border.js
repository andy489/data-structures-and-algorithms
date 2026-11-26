// https://leetcode.com/problems/coloring-a-border/

var colorBorder = function(grid, row, col, color) {
    const m = grid.length, n = grid[0].length, orig = grid[row][col];
    const visited = Array.from({length:m}, () => new Array(n).fill(false));
    const component = [], queue = [[row, col]];
    visited[row][col] = true;
    const dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    for (let i = 0; i < queue.length; i++) {
        const [r, c] = queue[i];
        component.push([r, c]);
        for (const [dr, dc] of dirs) {
            const [nr, nc] = [r+dr, c+dc];
            if (nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && grid[nr][nc]===orig) {
                visited[nr][nc] = true; queue.push([nr, nc]);
            }
        }
    }
    for (const [r, c] of component) {
        const border = r===0||r===m-1||c===0||c===n-1 || dirs.some(([dr,dc]) => grid[r+dr]?.[c+dc] !== orig);
        if (border) grid[r][c] = color;
    }
    return grid;
};
