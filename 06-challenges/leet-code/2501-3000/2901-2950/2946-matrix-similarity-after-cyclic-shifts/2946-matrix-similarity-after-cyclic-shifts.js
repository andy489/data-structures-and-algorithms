// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/

var areSimilar = function(mat, k) {
    const n = mat[0].length;
    const shift = k % n;
    if (shift === 0) return true;
    for (const row of mat) {
        for (let j = 1; j < n; j++) {
            if (row[j] !== row[0]) return false;
        }
    }
    return true;
};
