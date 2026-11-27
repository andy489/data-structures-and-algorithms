// https://leetcode.com/problems/last-day-where-you-can-still-cross/
var latestDayToCross = function(row, col, cells) {
    const canCross = (day) => {
        const water = Array.from({length: row}, () => new Uint8Array(col));
        for (let i = 0; i < day; i++) {
            water[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        const queue = [];
        for (let c = 0; c < col; c++) {
            if (!water[0][c]) {
                queue.push([0, c]);
                water[0][c] = 1;
            }
        }
        const dirs = [[1,0],[-1,0],[0,1],[0,-1]];
        let head = 0;
        while (head < queue.length) {
            const [r, c] = queue[head++];
            if (r === row - 1) {
                return true;
            }
            for (const [dr, dc] of dirs) {
                const nr = r + dr, nc = c + dc;
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !water[nr][nc]) {
                    water[nr][nc] = 1;
                    queue.push([nr, nc]);
                }
            }
        }
        return false;
    };

    let lo = 1, hi = cells.length;
    while (lo < hi) {
        const mid = lo + Math.floor((hi - lo + 1) / 2);
        if (canCross(mid)) {
            lo = mid;
        } else {
            hi = mid - 1;
        }
    }
    return lo;
};
