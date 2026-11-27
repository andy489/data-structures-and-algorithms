// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

var oddCells = function(m, n, indices) {
    const row = new Array(m).fill(0), col = new Array(n).fill(0);
    for (const [r, c] of indices) { row[r]++; col[c]++; }
    const oddR = row.filter(x => x%2).length, oddC = col.filter(x => x%2).length;
    return oddR * (n - oddC) + (m - oddR) * oddC;
};
