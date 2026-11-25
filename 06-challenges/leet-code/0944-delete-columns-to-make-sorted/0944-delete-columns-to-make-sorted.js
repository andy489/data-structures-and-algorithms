// https://leetcode.com/problems/delete-columns-to-make-sorted/

var minDeletionSize = function(strs) {
    let count = 0;
    for (let j = 0; j < strs[0].length; j++) {
        for (let i = 1; i < strs.length; i++) {
            if (strs[i][j] < strs[i-1][j]) { count++; break; }
        }
    }
    return count;
};
