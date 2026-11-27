// https://leetcode.com/problems/couples-holding-hands/

var minSwapsCouples = function(row) {
    let swaps = 0;
    for (let i = 0; i < row.length; i += 2) {
        const partner = row[i] ^ 1;
        if (row[i + 1] === partner) continue;
        for (let j = i + 2; j < row.length; j++) {
            if (row[j] === partner) {
                [row[i + 1], row[j]] = [row[j], row[i + 1]];
                swaps++; break;
            }
        }
    }
    return swaps;
};
