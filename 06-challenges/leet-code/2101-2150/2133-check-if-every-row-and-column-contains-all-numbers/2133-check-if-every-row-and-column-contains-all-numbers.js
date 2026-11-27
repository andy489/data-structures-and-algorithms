// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
var checkValid = function(matrix) {
    const n = matrix.length;
    for (let i = 0; i < n; i++) {
        const rowSet = new Set(matrix[i]);
        const colSet = new Set(matrix.map(row => row[i]));
        if (rowSet.size !== n || colSet.size !== n) {
            return false;
        }
    }
    return true;
};
