// https://leetcode.com/problems/pascals-triangle-ii/

// Solution 1: In-Place Update (Right to Left)
var getRow = function(rowIndex) {
    const row = [1];
    for (let i = 1; i <= rowIndex; i++) {
        row.push(0);
        for (let j = i; j >= 1; j--) {
            row[j] += row[j - 1];
        }
    }
    return row;
};

// Solution 2: Binomial Coefficient
var getRow2 = function(rowIndex) {
    const row = [1];
    for (let j = 1; j <= rowIndex; j++) {
        row.push(row[j - 1] * (rowIndex - j + 1) / j);
    }
    return row;
};
