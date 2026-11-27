// https://leetcode.com/problems/spiral-matrix-iii/

var spiralMatrixIII = function(rows, cols, rStart, cStart) {
    const dirs = [[0,1],[1,0],[0,-1],[-1,0]];
    const result = [];
    let r = rStart, c = cStart, d = 0, steps = 1;
    while (result.length < rows * cols) {
        for (let rep = 0; rep < 2; rep++) {
            for (let s = 0; s < steps; s++) {
                if (r >= 0 && r < rows && c >= 0 && c < cols) result.push([r, c]);
                r += dirs[d][0]; c += dirs[d][1];
            }
            d = (d + 1) % 4;
        }
        steps++;
    }
    return result;
};
