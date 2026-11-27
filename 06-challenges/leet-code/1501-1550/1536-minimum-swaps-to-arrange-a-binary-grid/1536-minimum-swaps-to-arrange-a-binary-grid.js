// https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/

var minSwaps = function(grid) {
    const n = grid.length;
    const trailing = grid.map(row => {
        let z = 0;
        for (let j = n - 1; j >= 0; j--) {
            if (row[j] === 0) z++;
            else break;
        }
        return z;
    });
    let swaps = 0;
    for (let i = 0; i < n; i++) {
        const need = n - 1 - i;
        let found = -1;
        for (let j = i; j < n; j++) {
            if (trailing[j] >= need) { found = j; break; }
        }
        if (found === -1) return -1;
        while (found > i) {
            [trailing[found], trailing[found - 1]] = [trailing[found - 1], trailing[found]];
            found--;
            swaps++;
        }
    }
    return swaps;
};
