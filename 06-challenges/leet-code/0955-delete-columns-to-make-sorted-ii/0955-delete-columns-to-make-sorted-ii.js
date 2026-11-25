// https://leetcode.com/problems/delete-columns-to-make-sorted-ii/

var minDeletionSize = function(strs) {
    const n = strs.length, m = strs[0].length;
    const sorted = new Array(n - 1).fill(false);
    let deleted = 0;
    for (let j = 0; j < m; j++) {
        let bad = false;
        for (let i = 0; i < n - 1; i++) {
            if (!sorted[i] && strs[i][j] > strs[i + 1][j]) { bad = true; break; }
        }
        if (bad) {
            deleted++;
        } else {
            for (let i = 0; i < n - 1; i++) {
                if (strs[i][j] < strs[i + 1][j]) sorted[i] = true;
            }
        }
    }
    return deleted;
};
