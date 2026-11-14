// https://leetcode.com/problems/pascals-triangle/

var generate = function(numRows) {
    const result = [[1]];
    for (let i = 1; i < numRows; i++) {
        const prev = result[i - 1];
        const row = [1];
        for (let j = 1; j < i; j++) {
            row.push(prev[j - 1] + prev[j]);
        }
        row.push(1);
        result.push(row);
    }
    return result;
};
