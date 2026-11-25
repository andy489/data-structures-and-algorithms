// https://leetcode.com/problems/champagne-tower/

var champagneTower = function(poured, query_row, query_glass) {
    let row = [poured];
    for (let i = 0; i < query_row; i++) {
        const next = new Array(i + 2).fill(0);
        for (let j = 0; j <= i; j++) {
            if (row[j] > 1) {
                const overflow = (row[j] - 1) / 2;
                next[j] += overflow;
                next[j + 1] += overflow;
            }
        }
        row = next;
    }
    return Math.min(1.0, row[query_glass]);
};
