// https://leetcode.com/problems/find-missing-and-repeated-values/
var findMissingAndRepeatedValues = function(grid) {
    const n = grid.length;
    const total = n * n;
    const count = new Array(total + 1).fill(0);
    for (const row of grid) {
        for (const val of row) {
            count[val]++;
        }
    }
    let repeated = -1, missing = -1;
    for (let i = 1; i <= total; i++) {
        if (count[i] === 2) {
            repeated = i;
        } else if (count[i] === 0) {
            missing = i;
        }
    }
    return [repeated, missing];
};
