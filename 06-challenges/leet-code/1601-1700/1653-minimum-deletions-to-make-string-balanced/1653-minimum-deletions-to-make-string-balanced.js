// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/

var minimumDeletions = function(s) {
    let bCount = 0, deletions = 0;
    for (const c of s) {
        if (c === 'b') {
            bCount++;
        } else {
            deletions = Math.min(deletions + 1, bCount);
        }
    }
    return deletions;
};
