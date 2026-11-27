// https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/
var maximumSubsequenceCount = function(text, pattern) {
    const p0 = pattern[0];
    const p1 = pattern[1];
    let base = 0;
    let countP0 = 0;
    let countP1 = 0;
    for (const c of text) {
        if (c === p1) {
            base += countP0;
            countP1++;
        }
        if (c === p0) {
            countP0++;
        }
    }
    return base + Math.max(countP0, countP1);
};
