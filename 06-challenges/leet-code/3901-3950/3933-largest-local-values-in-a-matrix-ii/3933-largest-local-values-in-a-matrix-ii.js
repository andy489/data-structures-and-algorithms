// https://leetcode.com/problems/largest-local-values-in-a-matrix-ii/

/**
 * @param {number[][]} matrix
 * @return {number}
 */
var largestLocal = function(matrix) {
    const n = matrix.length;
    const m = matrix[0].length;
    let count = 0;
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < m; c++) {
            const x = matrix[r][c];
            if (x === 0) {
                continue;
            }
            let isMax = true;
            outer:
            for (let dr = -x; dr <= x; dr++) {
                for (let dc = -x; dc <= x; dc++) {
                    if (Math.abs(dr) === x && Math.abs(dc) === x) {
                        continue;
                    }
                    const nr = r + dr;
                    const nc = c + dc;
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }
                    if (matrix[nr][nc] > x) {
                        isMax = false;
                        break outer;
                    }
                }
            }
            if (isMax) {
                count++;
            }
        }
    }
    return count;
};
