// https://leetcode.com/problems/zigzag-conversion/

var convert = function(s, numRows) {
    if (numRows === 1) {
        return s;
    }

    const rows = Array.from({ length: numRows }, () => []);
    let row = 0;
    let step = 1;

    for (const c of s) {
        rows[row].push(c);
        if (row === 0) {
            step = 1;
        }
        if (row === numRows - 1) {
            step = -1;
        }
        row += step;
    }

    return rows.map(r => r.join('')).join('');
};
