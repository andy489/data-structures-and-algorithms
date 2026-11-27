// https://leetcode.com/problems/pascals-triangle/

// Solution 1: Iterative Row Construction
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

// Solution 2: Binomial Coefficient
var generate2 = function(numRows) {
    const result = [];
    for (let i = 0; i < numRows; i++) {
        const row = [1];
        for (let j = 1; j <= i; j++) {
            row.push(row[j - 1] * (i - j + 1) / j);
        }
        result.push(row);
    }
    return result;
};

