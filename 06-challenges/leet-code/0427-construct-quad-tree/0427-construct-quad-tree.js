// https://leetcode.com/problems/construct-quad-tree/

var construct = function(grid) {
    const n = grid.length;
    const prefix = Array.from({length: n + 1}, () => new Array(n + 1).fill(0));

    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            prefix[r + 1][c + 1] = grid[r][c]
                + prefix[r][c + 1]
                + prefix[r + 1][c]
                - prefix[r][c];
        }
    }

    function rangeSum(r1, c1, r2, c2) {
        return prefix[r2 + 1][c2 + 1]
             - prefix[r1][c2 + 1]
             - prefix[r2 + 1][c1]
             + prefix[r1][c1];
    }

    function build(row, col, size) {
        const total = rangeSum(row, col, row + size - 1, col + size - 1);
        if (total === 0) {
            return new Node(false, true);
        }
        if (total === size * size) {
            return new Node(true, true);
        }
        const half = size >> 1;
        return new Node(
            true, false,
            build(row, col, half),
            build(row, col + half, half),
            build(row + half, col, half),
            build(row + half, col + half, half)
        );
    }

    return build(0, 0, n);
};
