// https://leetcode.com/problems/range-sum-query-2d-immutable/

// Solution: 2D Prefix Sum — O(m*n) build, O(1) query
class NumMatrix {
    constructor(matrix) {
        const m = matrix.length, n = matrix[0].length;
        this.prefix = Array.from({length: m + 1}, () => new Array(n + 1).fill(0));
        for (let i = 1; i <= m; i++) {
            for (let j = 1; j <= n; j++) {
                this.prefix[i][j] = matrix[i-1][j-1]
                    + this.prefix[i-1][j]
                    + this.prefix[i][j-1]
                    - this.prefix[i-1][j-1];
            }
        }
    }

    sumRegion(row1, col1, row2, col2) {
        return this.prefix[row2+1][col2+1]
            - this.prefix[row1][col2+1]
            - this.prefix[row2+1][col1]
            + this.prefix[row1][col1];
    }
}
