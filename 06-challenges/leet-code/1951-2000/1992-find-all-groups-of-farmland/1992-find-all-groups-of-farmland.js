// https://leetcode.com/problems/find-all-groups-of-farmland/
/**
 * @param {number[][]} land
 * @return {number[][]}
 */
var findFarmland = function(land) {
    const m = land.length, n = land[0].length;
    const result = [];
    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (land[r][c] === 1) {
                let r2 = r, c2 = c;
                while (r2 + 1 < m && land[r2 + 1][c] === 1) {
                    r2++;
                }
                while (c2 + 1 < n && land[r][c2 + 1] === 1) {
                    c2++;
                }
                result.push([r, c, r2, c2]);
                for (let i = r; i <= r2; i++) {
                    for (let j = c; j <= c2; j++) {
                        land[i][j] = 0;
                    }
                }
            }
        }
    }
    return result;
};
